package com.mokitooo.model.loan;

import lombok.*;

import java.time.LocalDate;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Loan {
    @Getter
    @EqualsAndHashCode.Include
    private final long id;
    @Getter
    @EqualsAndHashCode.Include
    private final long consumerId;
    @Getter
    @EqualsAndHashCode.Include
    private final long bookId;
    private final LocalDate loanDate;
    final boolean active;

    public Loan(long id, long consumerId, long bookId, LocalDate loanDate) {
        this(id, consumerId, bookId, loanDate, true);
    }

    public Loan withInactive() {
        return new Loan(id, consumerId, bookId, loanDate, false);
    }
}
