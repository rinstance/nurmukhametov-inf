package ru.itis.springbootdemo.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer countSoldItems;

    @OneToMany(mappedBy = "company")
    private List<Item> items;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountSoldItems(Integer countSoldItems) {
        this.countSoldItems = countSoldItems;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCountSoldItems() {
        return countSoldItems;
    }
}
