package com.bibliotheek.model;

public enum Language {
    EN("English"),
    NL("Nederland"),
    DE("Deutsch"),
    FR("French");

    private final String name;

    Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
