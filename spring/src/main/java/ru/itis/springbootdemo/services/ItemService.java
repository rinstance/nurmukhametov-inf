package ru.itis.springbootdemo.services;

import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.ItemDto;
import ru.itis.springbootdemo.dto.ItemForm;

@Component
public interface ItemService {
    ItemDto addItem(Integer companyId, ItemForm itemForm);
}
