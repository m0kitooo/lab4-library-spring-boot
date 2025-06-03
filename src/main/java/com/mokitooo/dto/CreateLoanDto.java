package com.mokitooo.dto;

import java.util.UUID;

public record CreateLoanDto(
        UUID consumerId,
        UUID bookId
) { }
