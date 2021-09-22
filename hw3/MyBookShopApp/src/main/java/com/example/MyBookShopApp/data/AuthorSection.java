package com.example.MyBookShopApp.data;

import java.util.List;

public class AuthorSection {

    private String capitalLetter;
    private List<Author> authors;

    public AuthorSection() {
    }

    public AuthorSection(String capitalLetter, List<Author> authors) {
        this.capitalLetter = capitalLetter;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "AuthorSection{" +
                "capitalLetter='" + capitalLetter + '\'' +
                ", authors=" + authors +
                '}';
    }

    public String getCapitalLetter() {
        return capitalLetter;
    }

    public void setCapitalLetter(String capitalLetter) {
        this.capitalLetter = capitalLetter;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
