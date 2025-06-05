package com.mokitooo.model.loan;

import java.util.function.Function;

public interface BookLoanMapper {
    Function<BookLoan, Boolean> LOAN_TO_ACTIVE = l -> l.active;
}
