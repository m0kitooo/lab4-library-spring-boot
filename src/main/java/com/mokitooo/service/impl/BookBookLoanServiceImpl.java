package com.mokitooo.service.impl;

import com.mokitooo.model.loan.Loan;
import com.mokitooo.repository.BookLoanRepository;
import com.mokitooo.service.BookLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mokitooo.model.loan.LoanMapper.LOAN_TO_ACTIVE;

@Service
@RequiredArgsConstructor
public class BookBookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepository bookLoanRepository;

    @Override
    public void borrowBook(Loan loan) {
        bookLoanRepository.save(loan);
    }

    @Override
    public void returnBook(long loanId) {
        bookLoanRepository.update(bookLoanRepository.findById(loanId).withInactive());
    }

    @Override
    public boolean areAllBooksReturned(Loan loan) {
        return bookLoanRepository
                .findAll()
                .stream()
                .noneMatch(LOAN_TO_ACTIVE::apply);
    }
}
