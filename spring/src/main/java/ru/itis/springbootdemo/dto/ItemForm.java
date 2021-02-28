package ru.itis.springbootdemo.dto;

public class ItemForm {
    private String name;
    private String img;
    private Integer count;

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public Integer getCount() {
        return count;
    }
}
