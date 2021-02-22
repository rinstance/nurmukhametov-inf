package ru.itis.repositories.items;

import ru.itis.models.entities.Item;
import ru.itis.repositories.CrudRepository;

public interface ItemRepository extends CrudRepository<Item> {
    void decCount(Integer id);
}
