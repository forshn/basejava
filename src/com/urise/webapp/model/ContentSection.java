package com.urise.webapp.model;

import java.util.Objects;

public class ContentSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private String text;

    public ContentSection() {
    }

    public ContentSection(String text) {
        Objects.requireNonNull(text, "text must not be null");
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentSection that = (ContentSection) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ContentSection{");
        sb.append("text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getText() {
        return text;
    }
}
