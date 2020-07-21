package com.urise.webapp.model;

public enum ContactType {
    TEL("Телефон"),
    SKYPE("Скайп"),
    MAIL("Почта"),
    LINKEDIN("LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    WEBSITE("Сайт");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title + " ";
    }
}
