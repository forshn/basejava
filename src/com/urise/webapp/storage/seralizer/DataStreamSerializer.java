package com.urise.webapp.storage.seralizer;

import com.urise.webapp.model.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class DataStreamSerializer implements StreamSerializer {

    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            dos.writeUTF(resume.getUuid());
            dos.writeUTF(resume.getFullName());
            Map<ContactType, String> contacts = resume.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeUTF(entry.getKey().name());
                dos.writeUTF(entry.getValue());
            });
            Map<SectionType, AbstractSection> sections = resume.getSections();
            writeCollection(dos, sections.entrySet(), entry -> writeSection(dos, entry));
        }
    }

    private void writeSection(DataOutputStream dos, Map.Entry<SectionType, AbstractSection> entry) throws IOException {
        AbstractSection section = entry.getValue();
        SectionType type = entry.getKey();
        dos.writeUTF(type.name());
        switch (type) {
            case PERSONAL:
            case OBJECTIVE:
                dos.writeUTF(((ContentSection) section).getText());
                break;
            case ACHIEVEMENT:
            case QUALIFICATION:
                List<String> list = ((ListSection) section).getContent();
                writeCollection(dos, list, dos::writeUTF);
                break;
            case EXPERIENCE:
            case EDUCATION:
                List<Organisation> organisations = ((OrganisationSection) section).getOrganisations();
                writeCollection(dos, organisations, organisation -> {
                    Link homePage = organisation.getWebsite();
                    dos.writeUTF(homePage.getTitle());
                    dos.writeUTF(homePage.getUrl() == null ? "" : homePage.getUrl());
                    List<Organisation.Position> positions = organisation.getPositionList();
                    writeCollection(dos, positions, position -> {
                        writeLocalDate(dos, position.getStartDate());
                        writeLocalDate(dos, position.getEndDate());
                        dos.writeUTF(position.getTitle());
                        dos.writeUTF(position.getDescription());
                    });
                });
                break;
        }
    }

    @Override
    public Resume doRead(InputStream is) throws IOException {
        try (DataInputStream dis = new DataInputStream(is)) {
            String uuid = dis.readUTF();
            String fullName = dis.readUTF();
            Resume resume = new Resume(uuid, fullName);
            readCollection(dis, () -> resume.addContact(ContactType.valueOf(dis.readUTF()), dis.readUTF()));
            readCollection(dis, () -> {
                String sectionName = dis.readUTF();
                SectionType sectionType = SectionType.valueOf(sectionName);
                resume.addSection(sectionType, readSection(dis, sectionType));
            });
            return resume;
        }
    }

    private AbstractSection readSection(DataInputStream dis, SectionType sectionType) throws IOException {
        switch (sectionType) {
            case PERSONAL:
            case OBJECTIVE:
                return new ContentSection(dis.readUTF());
            case ACHIEVEMENT:
            case QUALIFICATION:
                List<String> list = new ArrayList<>();
                readCollection(dis, () -> list.add(dis.readUTF()));
                return new ListSection(list);
            case EXPERIENCE:
            case EDUCATION:
                List<Organisation> organisations = new ArrayList<>();
                readCollection(dis, () -> {
                    String name = dis.readUTF();
                    String url = dis.readUTF();
                    url = (url.isEmpty() ? null : url);
                    List<Organisation.Position> positions = new ArrayList<>();
                    readCollection(dis, () -> {
                        LocalDate startDate = readLocalDate(dis.readInt(), dis.readInt());
                        LocalDate endDate = readLocalDate(dis.readInt(), dis.readInt());
                        String title = dis.readUTF();
                        String description = dis.readUTF();
                        positions.add(new Organisation.Position(startDate, endDate, title, description));
                    });
                    organisations.add(new Organisation(new Link(name, url), positions));
                });
                return new OrganisationSection(organisations);
        }
        return null;
    }

    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection, CollectionWriter<T> action) throws IOException {
        dos.writeInt(collection.size());
        for (T t : collection) {
            action.accept(t);
        }
    }

    @FunctionalInterface
    public interface CollectionWriter<T> {
        void accept(T t) throws IOException;
    }

    private void readCollection(DataInputStream dis, CollectionReader action) throws IOException {
        int size = dis.readInt();
        for (int i = 0; i < size; i++) {
            action.accept();
        }
    }

    @FunctionalInterface
    public interface CollectionReader {
        void accept() throws IOException;
    }

    private void writeLocalDate(DataOutputStream dos, LocalDate date) throws IOException {
        dos.writeInt(date.getYear());
        dos.writeInt(date.getMonth().getValue());
    }

    private LocalDate readLocalDate(int year, int month) {
        return LocalDate.of(year, month, 1);
    }
}
