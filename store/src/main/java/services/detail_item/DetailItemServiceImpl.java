package services.detail_item;

import dto.UserDto;
import models.Item;
import models.User;
import repositories.items.ItemRepository;

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








