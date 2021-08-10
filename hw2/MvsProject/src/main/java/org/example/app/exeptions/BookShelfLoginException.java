package org.example.app.exeptions;

public class BookShelfLoginException extends Exception {

    private final String massage;

    public BookShelfLoginException(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
