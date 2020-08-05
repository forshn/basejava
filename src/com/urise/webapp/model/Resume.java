package com.urise.webapp.model;

import java.util.*;

public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;

    private final Map<SectionType, AbstractSection> section = new EnumMap<>(SectionType.class);
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public AbstractSection getSection(SectionType type) {
        return section.get(type);
    }

    public void addSection(SectionType type, AbstractSection sections) {
        section.put(type, sections);
    }

    public String getContacts(ContactType type) {
        return contacts.get(type);
    }

    public void addContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public int compareTo(Resume o) {
        int compare = fullName.compareTo(o.fullName);
        if (compare == 0) return uuid.compareTo(o.uuid);
        return compare;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Resume{");
        sb.append("№ ").append(uuid).append('\'');
        sb.append("Имя: ").append(fullName).append('\'');
        sb.append(" ").append(section);
        sb.append(" ").append(contacts);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(section, resume.section) &&
                Objects.equals(contacts, resume.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, section, contacts);
    }
}