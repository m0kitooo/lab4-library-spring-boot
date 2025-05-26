package com.mokitooo.service;

import com.mokitooo.model.loan.Loan;
import com.mokitooo.repository.BookLoanRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mokitooo.model.loan.LoanMapper.LOAN_TO_ACTIVE;

@Service
@RequiredArgsConstructor
public class BookBookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepositoryImpl bookLoanRepositoryImpl;

    @Override
    public void borrowBook(Loan loan) {
        bookLoanRepositoryImpl.save(loan);
    }

    @Override
    public void returnBook(long loanId) {
        bookLoanRepositoryImpl.update(bookLoanRepositoryImpl.findById(loanId).withInactive());
    }

    @Override
    public boolean areAllBooksReturned(Loan loan) {
        return bookLoanRepositoryImpl
                .findAll()
                .stream()
                .noneMatch(LOAN_TO_ACTIVE::apply);
    }
}
