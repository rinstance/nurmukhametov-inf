package ru.itis.models;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {
    private Integer id;
    private Integer user_id;
    private Integer tx_id;
    private Timestamp order_time;
    private Date getDate;
    private String itemName;

    public Order() {}

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setTx_id(Integer tx_id) {
        this.tx_id = tx_id;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public Integer getTx_id() {
        return tx_id;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public Date getGetDate() {
        return getDate;
    }
}
