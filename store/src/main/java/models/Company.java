package models;

public class Company {
    private Integer id;
    private String name;
    private Integer countSoldItems;

    public Company() {}

    public Company(Integer id, String name, Integer countSoldItems) {
        this.id = id;
        this.name = name;
        this.countSoldItems = countSoldItems;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountSoldItems(Integer countSoldItems) {
        this.countSoldItems = countSoldItems;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCountSoldItems() {
        return countSoldItems;
    }
}
