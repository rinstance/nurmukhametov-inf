package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
