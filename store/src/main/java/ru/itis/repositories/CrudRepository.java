package ru.itis.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T entity);
    void update(T entity);
    void delete(Integer id);

    Optional<T> findById(Integer id);
    List<T> findAll();
}