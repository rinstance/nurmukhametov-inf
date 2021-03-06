package ru.itis.services.detail_item;

import ru.itis.models.entities.Item;
import ru.itis.repositories.items.ItemRepository;

import java.util.Optional;

public class DetailItemServiceImpl implements DetailItemService {
    private ItemRepository itemRepository;

    public DetailItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item getDetailItemById(Integer id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            return itemOptional.get();
        }
        return null;
    }

    @Override
    public void updateOrDeleteById(Item item) {
        if (item.getCount() == 1)
            itemRepository.delete(item.getId());
        else
            itemRepository.decCount(item.getId());
    }
}








