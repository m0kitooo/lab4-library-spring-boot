package com.mokitooo.repository;

import com.mokitooo.model.Consumer;
import com.mokitooo.model.loan.BookLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class BookLoanRepositoryAsyncImpl implements BookLoanRepository {
    private final BookRepository bookRepository;
    private final ConsumerRepository consumerRepository;
    private final Map<UUID, BookLoan> loans = new ConcurrentHashMap<>();

    @Autowired
    public BookLoanRepositoryAsyncImpl(
            BookRepositoryAsyncImpl bookRepository,
            ConsumerRepositoryAsyncImpl consumerRepository
    ) {
        this.bookRepository = bookRepository;
        this.consumerRepository = consumerRepository;
    }

    public BookLoanRepositoryAsyncImpl(
            List<BookLoan> bookLoans,
            BookRepositoryAsyncImpl bookRepository,
            ConsumerRepositoryAsyncImpl consumerRepository
    ) {
        this.bookRepository = bookRepository;
        this.consumerRepository = consumerRepository;
        bookLoans.forEach(this::save);
    }

    @Override
    public Optional<BookLoan> findById(UUID id) {
        return Optional.ofNullable(loans.get(id));
    }

    @Override
    public Set<BookLoan> findAll() {
        return new HashSet<>(loans.values());
    }

    @Override
    public void save(BookLoan bookLoan) {
        if (bookAndConsumerExist(bookLoan)) {
            loans.putIfAbsent(bookLoan.getId(), bookLoan);
        }
    }

    @Override
    public void update(BookLoan bookLoan) {
        if (bookAndConsumerExist(bookLoan) && loans.containsKey(bookLoan.getId())) {
            loans.put(bookLoan.getId(), bookLoan);
        }
    }

    @Override
    public List<Consumer> findConsumersByBookId(UUID bookId) {
        Set<UUID> consumerIdsByBook = loans
                .values()
                .stream()
                .filter(l -> l.getBookId().equals(bookId))
                .map(BookLoan::getConsumerId)
                .collect(Collectors.toSet());

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

    private boolean bookAndConsumerExist(BookLoan bookLoan) {
        return bookExists(bookLoan.getBookId()) && consumerExists(bookLoan.getConsumerId());
    }
}
