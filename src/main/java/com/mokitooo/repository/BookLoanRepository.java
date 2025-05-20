package com.mokitooo.repository;

import com.mokitooo.model.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookLoanRepository {
    private final BookRepository bookRepository;
    private final ConsumerRepository consumerRepository;
    private final Map<Long, Loan> loans = new HashMap<>();

    @Autowired
    public BookLoanRepository(BookRepository bookRepository, ConsumerRepository consumerRepository) {
        this.bookRepository = bookRepository;
        this.consumerRepository = consumerRepository;
    }

    public BookLoanRepository(
            List<Loan> loans,
            BookRepository bookRepository,
            ConsumerRepository consumerRepository
    ) {
        this.bookRepository = bookRepository;
        this.consumerRepository = consumerRepository;
        loans.forEach(this::save);
    }

    public Set<Loan> findAll() {
        return new HashSet<>(loans.values());
    }

    public Loan findById(Long id) {
        return loans.get(id);
    }

    public void save(Loan loan) {
        if (bookAndConsumerExist(loan)) {
            loans.putIfAbsent(loan.getId(), loan);
        }
    }

    public void update(Loan loan) {
        if (bookAndConsumerExist(loan) && loans.containsKey(loan.getId())) {
            loans.put(loan.getId(), loan);
        }
    }

    private boolean bookExists(Long id) {
        return bookRepository.findById(id).isPresent();
    }

    private boolean consumerExists(Long id) {
        return consumerRepository.findById(id).isPresent();
    }

    private boolean bookAndConsumerExist(Loan loan) {
        return bookExists(loan.getBookId()) && consumerExists(loan.getConsumerId());
    }
}
