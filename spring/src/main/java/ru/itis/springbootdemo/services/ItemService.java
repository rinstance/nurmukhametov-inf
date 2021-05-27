package ru.itis.springbootdemo.services;

import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.dto.ItemPage;
import ru.itis.springbootdemo.models.Item;

import java.util.List;

public interface ItemService {
    ItemDto addItem(Integer companyId, ItemForm itemForm);
    ItemPage search(Integer size, Integer page, String query, String sort, String direction);
    List<Item> getAll();
    Item getById(Long itemId);
    void changeCounts(Long itemId);
    List<Item> mapToItems(List<ItemDto> searchItems);
}
