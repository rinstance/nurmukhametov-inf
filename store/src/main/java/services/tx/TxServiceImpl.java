package services.tx;

import dto.UserDto;
import models.Transaction;
import models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.tx.TxRepository;
import repositories.user.UserRepository;

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
