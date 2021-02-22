package ru.itis.services.items;

import ru.itis.models.dto.ItemDto;
import ru.itis.models.entities.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItems();
    void add(ItemDto itemDto);
}
