package ru.itis.models;

public class Item {
    private Integer id;
    private String name;
    private Integer company_id;
    private Integer count;
    private String img;

    public Item() {}

    public Item(Integer id, String name, Integer company_id, Integer count, String img) {
        this.id = id;
        this.name = name;
        this.company_id = company_id;
        this.count = count;
        this.img = img;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public Integer getCount() {
        return count;
    }

    public String getImg() {
        return img;
    }
}
