package ru.itis.springbootdemo.services;

import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;
import ru.itis.springbootdemo.dto.ItemPage;

public interface ItemService {
    ItemDto addItem(Integer companyId, ItemForm itemForm);
    ItemPage search(Integer size, Integer page, String query, String sort, String direction);
}
