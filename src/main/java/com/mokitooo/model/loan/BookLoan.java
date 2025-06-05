package com.mokitooo.model.loan;

import lombok.NonNull;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString
public class BookLoan {
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

    public BookLoan(UUID id, UUID consumerId, UUID bookId, LocalDate loanDate) {
        this(id, consumerId, bookId, loanDate, true);
    }

    public BookLoan withInactive() {
        return new BookLoan(id, consumerId, bookId, loanDate, false);
    }
}
