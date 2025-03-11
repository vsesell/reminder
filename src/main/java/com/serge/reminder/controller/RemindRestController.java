package com.serge.reminder.controller;

import com.serge.reminder.dto.PageResponse;
import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.dto.RemindSortingDto;
import com.serge.reminder.service.RemindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Time;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RemindRestController {
    private final RemindService remindService;

    @GetMapping("list")
    public PageResponse<RemindReadDto> findAll(Pageable pageable) {
        return PageResponse.of(remindService.findAll(pageable));
    }

    @GetMapping("/sort")
    public PageResponse<RemindSortingDto> findAllWithSort(Pageable pageable) {
        return PageResponse.of(remindService.findAllWithSort(pageable));
    }

    @GetMapping("/filter")
    public PageResponse<RemindSortingDto> findFilterDateTime(Date date, Time time,Pageable pageable) {
        return PageResponse.of(remindService.findFilterDateTime(date, time, pageable));
    }
}
