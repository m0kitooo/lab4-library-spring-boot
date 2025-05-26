package com.mokitooo.service;

import com.mokitooo.dto.BorrowBookDto;
import com.mokitooo.model.book.Book;
import com.mokitooo.model.loan.Loan;
import com.mokitooo.repository.BookLoanRepositoryAsyncImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

import static com.mokitooo.model.loan.LoanMapper.LOAN_TO_ACTIVE;

@Service
@RequiredArgsConstructor
public class BookBookLoanServiceImpl implements BookLoanService {
    private final BookLoanRepositoryAsyncImpl bookLoanRepositoryAsyncImpl;
    private final BookSearchService bookSearchService;

    @Override
    public void borrowBook(BorrowBookDto borrowBookDto) {
        Book bookToBorrow = bookSearchService.findByTitle(borrowBookDto.bookTitle()).getFirst();

        bookLoanRepositoryAsyncImpl.save(
                Loan
                        .builder()
                        .id(UUID.randomUUID())
                        .bookId(bookToBorrow.getId())
                        .consumerId(borrowBookDto.consumer().getId())
                        .loanDate(LocalDate.now())
                        .active(true)
                        .build()
        );
    }

    @Override
    public void returnBook(UUID loanId) {
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
