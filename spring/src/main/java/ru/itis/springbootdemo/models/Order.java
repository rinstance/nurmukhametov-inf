package ru.itis.springbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "all_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "tx_id")
    private Integer txId;
    @Column(name = "order_time")
    private Timestamp orderTime;
    @Column(name = "get_date")
    private Date getDate;
    @Column(name = "item_name")
    private String itemName;

    public Order() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTxId(Integer txId) {
        this.txId = txId;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public void setItem(String item) {
        this.itemName = item;
    }

    public Integer getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Integer getTxId() {
        return txId;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public Date getGetDate() {
        return getDate;
    }

    public String getItem() {
        return itemName;
    }
}
