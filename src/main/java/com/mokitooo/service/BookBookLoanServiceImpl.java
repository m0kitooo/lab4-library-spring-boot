package com.mokitooo.service;

import com.mokitooo.model.loan.Loan;
import com.mokitooo.repository.BookLoanRepositoryAsyncImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mokitooo.model.loan.LoanMapper.LOAN_TO_ACTIVE;

@Service
@RequiredArgsConstructor
public class BookBookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepositoryAsyncImpl bookLoanRepositoryAsyncImpl;

    @Override
    public void borrowBook(Loan loan) {
        bookLoanRepositoryAsyncImpl.save(loan);
    }

    @Override
    public void returnBook(long loanId) {
        bookLoanRepositoryAsyncImpl.update(bookLoanRepositoryAsyncImpl.findById(loanId).withInactive());
    }

    @Override
    public boolean areAllBooksReturned(Loan loan) {
        return bookLoanRepositoryAsyncImpl
                .findAll()
                .stream()
                .noneMatch(LOAN_TO_ACTIVE::apply);
    }
}
