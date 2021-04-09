package ru.itis.springbootdemo.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.models.Company;
import ru.itis.springbootdemo.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select item from Item item where " +
            "(:q = 'empty' or UPPER(item.name) like UPPER(concat('%', :q, '%')))")
    Page<Item> search(@Param("q") String q, Pageable pageable);

}
