package services.items;

import models.Item;
import repositories.items.ItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
