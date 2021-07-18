package org.example.web.dto;

public class SubscribeForm {

    private String userName;
    private String password;

    public SubscribeForm(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public SubscribeForm() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SubscribeForm{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
