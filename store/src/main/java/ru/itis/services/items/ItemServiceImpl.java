package ru.itis.services.items;

import ru.itis.models.dto.ItemDto;
import ru.itis.models.entities.Item;
import ru.itis.repositories.items.ItemRepository;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public void add(ItemDto itemDto) {
        itemRepository.save(new Item(
                itemDto.getTitle(),
                itemDto.getCompanyId(),
                itemDto.getCount(),
                itemDto.getImage()
        ));
    }
}
