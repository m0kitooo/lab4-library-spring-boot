package com.mokitooo.service;

import com.mokitooo.dto.BookDto;
import com.mokitooo.dto.ConsumerDto;

import java.util.List;
import java.util.Map;

public interface BookAnalyticsService {
    Map<BookDto, List<ConsumerDto>> getGeneralBookReport();
}
