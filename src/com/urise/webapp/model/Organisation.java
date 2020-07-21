package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organisation {
    private final Link website;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;

    public Organisation(String name, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        this.website = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organisation{");
        sb.append("Сайт ").append(website);
        sb.append("Дата начала ").append(startDate);
        sb.append("Дата окончания ").append(endDate);
        sb.append("Должность").append(title).append('\'');
        sb.append("Описание").append(description).append('\'');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organisation that = (Organisation) o;
        return Objects.equals(website, that.website) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, startDate, endDate, title, description);
    }


}
