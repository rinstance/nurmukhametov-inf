package services.detail_item;

import models.Item;

public interface DetailItemService {
    Item getDetailItemById(Integer id);
    void updateOrDeleteById(Item item);
}
