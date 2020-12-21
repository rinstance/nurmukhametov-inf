package repositories.tx;

import models.Transaction;
import repositories.CrudRepository;

public interface TxRepository extends CrudRepository<Transaction> {
    Transaction getLast();
}
