package com.urise.webapp.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume>{

    private final String uuid;
    private final String fullName;

    private final Map<SectionType, AbstractSection> text = new HashMap<>();
    private final Map<ContactType, String> contacts = new HashMap<>();

    public AbstractSection getText(SectionType type) {
        return text.get(type);
    }

    public String getContacts(ContactType type) {
        return contacts.get(type);
    }

    public void addContact(ContactType type, String value) {
        contacts.put(type, value);
    }

    public void addSection(SectionType type, AbstractSection section) {
        text.put(type, section);
    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
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
        sb.append(" ").append(text);
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
                Objects.equals(fullName, resume.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }
}