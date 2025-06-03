package com.mokitooo.service;

import com.mokitooo.dto.CreateLoanDto;
import com.mokitooo.model.book.Book;
import com.mokitooo.model.loan.Loan;
import com.mokitooo.repository.BookLoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

import static com.mokitooo.model.loan.LoanMapper.LOAN_TO_ACTIVE;

@Service
@RequiredArgsConstructor
public class BookBookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepository bookLoanRepository;

    @Override
    public void borrowBook(CreateLoanDto createLoanDto) {
        bookLoanRepository.save(new Loan(
                UUID.randomUUID(),
                createLoanDto.consumerId(),
                createLoanDto.bookId(),
                LocalDate.now()
        ));
    }

    @Override
    public void returnBook(UUID id) {
        bookLoanRepository.update(bookLoanRepository.findById(id).withInactive());
    }

    @Override
    public boolean areAllBooksReturned() {
        return bookLoanRepository
                .findAll()
                .stream()
                .noneMatch(LOAN_TO_ACTIVE::apply);
    }
}
