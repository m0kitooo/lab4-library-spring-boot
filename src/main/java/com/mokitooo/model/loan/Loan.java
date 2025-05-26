package com.mokitooo.model.loan;

import lombok.NonNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class Loan {
    @Getter
    @EqualsAndHashCode.Include
    private final UUID id;
    @Getter
    @EqualsAndHashCode.Include
    private final UUID consumerId;
    @Getter
    @EqualsAndHashCode.Include
    private final UUID bookId;
    @NonNull
    private final LocalDate loanDate;
    final boolean active;

    public Loan(UUID id, UUID consumerId, UUID bookId, LocalDate loanDate) {
        this(id, consumerId, bookId, loanDate, true);
    }

    public Loan withInactive() {
        return new Loan(id, consumerId, bookId, loanDate, false);
    }
}
