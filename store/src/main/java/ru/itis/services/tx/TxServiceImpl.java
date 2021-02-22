package ru.itis.services.tx;

import ru.itis.models.entities.Transaction;
import ru.itis.repositories.tx.TxRepository;

import java.util.List;
import java.util.Optional;

public class TxServiceImpl implements TxService {
    private TxRepository txRepository;

    public TxServiceImpl(TxRepository txRepository) {
        this.txRepository = txRepository;
    }

    @Override
    public List<Transaction> getAllTx() {
        return null;
    }

    @Override
    public void add(Transaction transaction) {
        txRepository.save(transaction);
    }

    @Override
    public Transaction getLast() {
        return txRepository.getLast();
    }

    @Override
    public Transaction getById(Integer id) {
        Optional<Transaction> transaction = txRepository.findById(id);
        return transaction.orElse(null);
    }
}
