package com.serge.reminder.controller;

import com.serge.reminder.dto.PageResponse;
import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.service.RemindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RemindRestController {
    private final RemindService remindService;

    @GetMapping("list")
    public PageResponse<RemindReadDto> findAll(Pageable pageable) {
        Page<RemindReadDto> page = remindService.findAll(pageable);
        return PageResponse.of(page.getTotalPages(),
                page.getNumber(),
                page.getContent());
    }

}
