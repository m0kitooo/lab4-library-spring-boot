package com.mokitooo.repository;

import com.mokitooo.model.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookLoanRepositoryImpl implements BookLoanRepository {
    private final BookRepositoryImpl bookRepositoryImpl;
    private final ConsumerRepositoryImpl consumerRepositoryImpl;
    private final Map<Long, Loan> loans = new HashMap<>();

    @Autowired
    public BookLoanRepositoryImpl(BookRepositoryImpl bookRepositoryImpl, ConsumerRepositoryImpl consumerRepositoryImpl) {
        this.bookRepositoryImpl = bookRepositoryImpl;
        this.consumerRepositoryImpl = consumerRepositoryImpl;
    }

    public BookLoanRepositoryImpl(
            List<Loan> loans,
            BookRepositoryImpl bookRepositoryImpl,
            ConsumerRepositoryImpl consumerRepositoryImpl
    ) {
        this.bookRepositoryImpl = bookRepositoryImpl;
        this.consumerRepositoryImpl = consumerRepositoryImpl;
        loans.forEach(this::save);
    }

    @Override
    public Loan findById(Long id) {
        return loans.get(id);
    }

    @Override
    public Set<Loan> findAll() {
        return new HashSet<>(loans.values());
    }

    @Override
    public void save(Loan loan) {
        if (bookAndConsumerExist(loan)) {
            loans.putIfAbsent(loan.getId(), loan);
        }
    }

    @Override
    public void update(Loan loan) {
        if (bookAndConsumerExist(loan) && loans.containsKey(loan.getId())) {
            loans.put(loan.getId(), loan);
        }
    }

    private boolean bookExists(Long id) {
        return bookRepositoryImpl.findById(id).isPresent();
    }

    private boolean consumerExists(Long id) {
        return consumerRepositoryImpl.findById(id).isPresent();
    }

    private boolean bookAndConsumerExist(Loan loan) {
        return bookExists(loan.getBookId()) && consumerExists(loan.getConsumerId());
    }
}
