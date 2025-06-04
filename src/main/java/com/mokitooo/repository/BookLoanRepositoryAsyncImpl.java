package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import com.mokitooo.model.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookLoanRepositoryAsyncImpl implements BookLoanRepository {
    private final BookRepository bookRepository;
    private final ConsumerRepository consumerRepository;
    private final Map<UUID, Loan> loans = new ConcurrentHashMap<>();

    @Autowired
    public BookLoanRepositoryAsyncImpl(
            BookRepositoryAsyncImpl bookRepository,
            ConsumerRepositoryAsyncImpl consumerRepository
    ) {
        this.bookRepository = bookRepository;
        this.consumerRepository = consumerRepository;
    }

    public BookLoanRepositoryAsyncImpl(
            List<Loan> loans,
            BookRepositoryAsyncImpl bookRepository,
            ConsumerRepositoryAsyncImpl consumerRepository
    ) {
        this.bookRepository = bookRepository;
        this.consumerRepository = consumerRepository;
        loans.forEach(this::save);
    }

    @Override
    public Optional<Loan> findById(UUID id) {
        return Optional.ofNullable(loans.get(id));
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

    @Override
    public List<Consumer> findConsumersByBookId(UUID bookId) {
        List<UUID> consumerIdsByBook = loans
                .values()
                .stream()
                .filter(l -> l.getBookId().equals(bookId))
                .map(Loan::getConsumerId)
                .toList();

        return consumerRepository
                .findAll()
                .stream()
                .filter(consumer -> consumerIdsByBook.contains(consumer.getId()))
                .toList();
    }

    private boolean bookExists(UUID id) {
        return bookRepository.findById(id).isPresent();
    }

    private boolean consumerExists(UUID id) {
        return consumerRepository.findById(id).isPresent();
    }

    private boolean bookAndConsumerExist(Loan loan) {
        return bookExists(loan.getBookId()) && consumerExists(loan.getConsumerId());
    }
}
