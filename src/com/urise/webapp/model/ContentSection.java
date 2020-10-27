package com.urise.webapp.model;

import java.sql.Connection;
import java.util.Objects;

public class ContentSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private String text;
    public static final ContentSection EMPTY = new ContentSection("");

    public ContentSection() {
    }

    public ContentSection(String text) {
        Objects.requireNonNull(text, "text must not be null");
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentSection that = (ContentSection) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public String getText() {
        return text;
    }
}
