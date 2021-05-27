package ru.itis.springbootdemo.dto;

import java.util.List;

public class ItemPage {
    private int pagesCount;
    private int size;
    private List<ItemDto> items;

    public ItemPage() {

    }

    public ItemPage(int pagesCount, List<ItemDto> items) {
        this.pagesCount = pagesCount;
        this.items = items;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
