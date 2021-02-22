package ru.itis.services.detail_item;

import ru.itis.models.entities.Item;

public interface DetailItemService {
    Item getDetailItemById(Integer id);
    void updateOrDeleteById(Item item);
}
