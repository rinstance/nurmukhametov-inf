package ru.itis.models.dto;

public class ItemDto {
    private String title;
    private String image;
    private Integer count;
    private Integer companyId;

    public ItemDto(String title, String image, Integer count, Integer companyId) {
        this.title = title;
        this.image = image;
        this.count = count;
        this.companyId = companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Integer getCount() {
        return count;
    }
}
