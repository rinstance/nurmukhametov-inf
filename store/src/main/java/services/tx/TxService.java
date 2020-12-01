package services.tx;

import models.Transaction;

import java.util.List;

public interface TxService {
    List<Transaction> getAllTx();
    void add(Transaction transaction);
    Transaction getLast();
    Transaction getById(Integer id);
}
