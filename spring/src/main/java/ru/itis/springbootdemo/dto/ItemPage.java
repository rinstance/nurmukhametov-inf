package ru.itis.springbootdemo.dto;

import java.util.List;

public class ItemPage {
    private int pagesCount;
    private List<ItemDto> papers;

    public ItemPage() {

    }

    public ItemPage(int pagesCount, List<ItemDto> papers) {
        this.pagesCount = pagesCount;
        this.papers = papers;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public List<ItemDto> getPapers() {
        return papers;
    }

    public void setPagesCount(int pagesCount) {
        this.pagesCount = pagesCount;
    }

    public void setPapers(List<ItemDto> papers) {
        this.papers = papers;
    }
}
