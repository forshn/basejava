package com.urise.webapp.model;

public enum ContactType {
    TEL("Телефон"),
    SKYPE("Скайп") {
        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink("skype:" + value, value);
        }
    },
    MAIL("Почта"){
        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink("mailto:" + value, value);
        }
    },
    LINKEDIN("LinkedIn") {
        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink("https://www.linkedin.com" + value, value);
        }
    },
    GITHUB("Профиль GitHub") {
        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink("github." + value, value);
        }
    },
    STACKOVERFLOW("Профиль Stackoverflow")  {
        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink("https://stackoverflow.com" + value, value);
        }
    },
    WEBSITE("Сайт") {
        @Override
        public String toHtml0(String value) {
            return getTitle() + ": " + toLink(value, value);
        }
    };

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    protected String toHtml0(String value) {
        return title + ": " + value;
    }

    public String toHtml(String value) {
        return (value == null) ? "" : toHtml0(value);
    }

    public String toLink(String href) {
        return toLink(href, title);
    }

    public static String toLink(String href, String title) {
        return "<a href='" + href + "'>" + title + "</a>";
    }
}
