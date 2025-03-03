package com.serge.reminder;

import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.service.RemindService;
import lombok.RequiredArgsConstructor;
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
    public List<RemindReadDto> findAll() {
        return remindService.findAll();
    }
}
