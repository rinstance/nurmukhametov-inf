package ru.itis.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    protected Integer id;
    protected String firstName;
    protected String lastName;
    protected String login;
    protected String hashPassword;
    private Integer countPurchasedItems;

    public User() {}

    public User(String firstName, String lastName, String login, String hashPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.hashPassword = hashPassword;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public Integer getCountPurchasedItems() {
        return countPurchasedItems;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setCountPurchasedItems(Integer countPurchasedItems) {
        this.countPurchasedItems = countPurchasedItems;
    }
}
