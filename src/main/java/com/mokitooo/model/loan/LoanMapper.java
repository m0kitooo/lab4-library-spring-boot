package com.mokitooo.model.loan;

import java.util.function.Function;

public interface LoanMapper {
    Function<Loan, Boolean> LOAN_TO_ACTIVE = l -> l.active;
}
