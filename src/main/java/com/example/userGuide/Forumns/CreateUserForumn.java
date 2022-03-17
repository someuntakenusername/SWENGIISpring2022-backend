package com.example.userGuide.Forumns;

public class CreateUserForumn {

    private String nameFirst;
    private String nameLast;
    private String email;
    private String password;

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CreateUserForumn{" +
                "nameFirst='" + nameFirst + '\'' +
                ", nameLast='" + nameLast + '\'' + ", email='" + email + '\'' +
                ", password='" + password + '\'' + '}';
    }
}
