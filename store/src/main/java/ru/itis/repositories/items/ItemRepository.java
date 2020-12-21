package repositories.items;

import models.Item;
import repositories.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item> {
    void decCount(Integer id);
}
