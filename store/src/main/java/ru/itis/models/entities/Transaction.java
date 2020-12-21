package ru.itis.models;

public class Transaction {
    private Integer id;
    private String type;

    public Transaction() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Transaction(Integer id, String type) {
        this.id = id;
        this.type = type;
    }
}
