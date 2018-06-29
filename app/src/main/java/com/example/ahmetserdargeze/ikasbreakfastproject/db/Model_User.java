package com.example.ahmetserdargeze.ikasbreakfastproject.db;

/**
 * Created by ahmetserdargeze on 28.06.2018.
 */

public class Model_User {
    private int id;
    private String token;
    private String mail;
    private String name;
    private String surname;

    public Model_User() {
    }

    public Model_User(int id, String token, String mail, String name, String surname) {
        this.id = id;
        this.token = token;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
