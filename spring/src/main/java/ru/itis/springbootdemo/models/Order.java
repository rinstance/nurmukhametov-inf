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
@Table(name = "customers_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "order_time")
    private Date orderTime;
    @Column(name = "get_date")
    private Date getDate;
    @Column(name = "item_id")
    private Long itemId;

    public Order() {}

    public Order(Long userId, Date orderTime, Date getDate, Long itemId) {
        this.userId = userId;
        this.orderTime = orderTime;
        this.getDate = getDate;
        this.itemId = itemId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public Integer getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getGetDate() {
        return getDate;
    }

    public Long getItemId() {
        return itemId;
    }
}
