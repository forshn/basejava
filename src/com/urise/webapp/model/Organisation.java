package com.urise.webapp.model;

import com.urise.webapp.utils.LocalDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Link website;
    private List<Position> positionList;

    public Organisation() {
    }

    public Link getWebsite() {
        return website;
    }

    public Organisation(Link website, List<Position> positionList) {
        this.positionList = positionList;
        this.website = website;
    }

    public Organisation(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organisation that = (Organisation) o;
        return Objects.equals(website, that.website) &&
                Objects.equals(positionList, that.positionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(website, positionList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organisation{");
        sb.append("website=").append(website);
        sb.append(", ").append(positionList);
        sb.append('}');
        return sb.toString();
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Position implements Serializable {
        private static final long serialVersionUID = 1L;
        private String title;
        private String description;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)
        private LocalDate startDate;
        @XmlJavaTypeAdapter(LocalDateAdapter.class)

        private LocalDate endDate;

        public Position() {
        }

        public String getDescription() {
            return description;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "start date mustn't be null");
            Objects.requireNonNull(endDate, "end date mustn't be null");
            Objects.requireNonNull(title, "title date mustn't be null");
            this.title = title;
            this.description = description;
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public String getTitle() {
            return title;
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(title, position.title) &&
                    Objects.equals(description, position.description) &&
                    Objects.equals(startDate, position.startDate) &&
                    Objects.equals(endDate, position.endDate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(title, description, startDate, endDate);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Position{");
            sb.append("title='").append(title).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", startDate=").append(startDate);
            sb.append(", endDate=").append(endDate);
            sb.append('}');
            return sb.toString();
        }
    }
}
