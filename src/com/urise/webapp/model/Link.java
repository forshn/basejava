package com.urise.webapp.model;

import java.util.Objects;

public class Link {
    private final String title;
    private final String url;

    public Link(String title, String url) {
        Objects.requireNonNull(title, "title musn't be null");
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(title, link.title) &&
                Objects.equals(url, link.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, url);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Link{");
        sb.append("title='").append(title).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
