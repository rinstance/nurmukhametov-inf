package ru.itis.repositories.tx;

import ru.itis.models.entities.Transaction;
import ru.itis.repositories.CrudRepository;

public interface TxRepository extends CrudRepository<Transaction> {
    Transaction getLast();
}
