package com.mokitooo.repository;

import com.mokitooo.model.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookLoanRepositoryAsyncImpl implements BookLoanRepository {
    private final BookRepositoryAsyncImpl bookRepositoryAsyncImpl;
    private final ConsumerRepositoryAsyncImpl consumerRepositoryAsyncImpl;
    private final Map<Long, Loan> loans = new ConcurrentHashMap<>();

    @Autowired
    public BookLoanRepositoryAsyncImpl(
            BookRepositoryAsyncImpl bookRepositoryAsyncImpl,
            ConsumerRepositoryAsyncImpl consumerRepositoryAsyncImpl
    ) {
        this.bookRepositoryAsyncImpl = bookRepositoryAsyncImpl;
        this.consumerRepositoryAsyncImpl = consumerRepositoryAsyncImpl;
    }

    public BookLoanRepositoryAsyncImpl(
            List<Loan> loans,
            BookRepositoryAsyncImpl bookRepositoryAsyncImpl,
            ConsumerRepositoryAsyncImpl consumerRepositoryAsyncImpl
    ) {
        this.bookRepositoryAsyncImpl = bookRepositoryAsyncImpl;
        this.consumerRepositoryAsyncImpl = consumerRepositoryAsyncImpl;
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
        return bookRepositoryAsyncImpl.findById(id).isPresent();
    }

    private boolean consumerExists(Long id) {
        return consumerRepositoryAsyncImpl.findById(id).isPresent();
    }

    private boolean bookAndConsumerExist(Loan loan) {
        return bookExists(loan.getBookId()) && consumerExists(loan.getConsumerId());
    }
}
