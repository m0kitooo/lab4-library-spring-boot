package com.mokitooo.service;

import com.mokitooo.dto.BorrowBookDto;
import com.mokitooo.dto.ReturnBookDto;
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
    private final BookLoanRepositoryAsyncImpl bookLoanRepository;
    private final BookSearchService bookSearchService;

    @Override
    public void borrowBook(BorrowBookDto borrowBookDto) {
        Book bookToBorrow = bookSearchService.findByTitle(borrowBookDto.bookTitle()).getFirst();

        bookLoanRepository.save(
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
    public void returnBook(ReturnBookDto returnBookDto) {
        Book book = bookSearchService.findByTitle(returnBookDto.title()).getFirst();
        UUID loanId = bookLoanRepository.findById(book.getId()).getId();

        bookLoanRepository.update(bookLoanRepository.findById(loanId).withInactive());
    }

    @Override
    public boolean areAllBooksReturned() {
        return bookLoanRepository
                .findAll()
                .stream()
                .noneMatch(LOAN_TO_ACTIVE::apply);
    }
}
