package ru.itis.springbootdemo.dto;

import ru.itis.springbootdemo.models.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemDto {
    private Long id;
    private String name;
    private String img;
    private Integer count;

    public static ItemDto from(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.id = item.getId();
        itemDto.name = item.getName();
        itemDto.img = item.getImg();
        itemDto.count = item.getCount();
        return itemDto;
    }

    public static List<ItemDto> from(List<Item> items) {
        return items.stream()
                .map(ItemDto::from)
                .collect(Collectors.toList());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getId() {
        return id;
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
