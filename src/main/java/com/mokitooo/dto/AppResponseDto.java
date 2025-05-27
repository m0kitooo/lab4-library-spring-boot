package com.mokitooo.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AppResponseDto<T> {
    public final T data;
    public final RuntimeException error;

    public static <T> AppResponseDto<T> success(T data) {
        return new AppResponseDto<>(data, null);
    }

    public static AppResponseDto<Void> error(RuntimeException error) {
        return new AppResponseDto<>(null, error);
    }
}
