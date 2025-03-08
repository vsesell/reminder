package com.serge.reminder.service;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.mapper.RemindCreateEditMapper;
import com.serge.reminder.mapper.RemindCreateEditMsMapper;
import com.serge.reminder.mapper.RemindReadMapper;
import com.serge.reminder.mapper.RemindReadMsMapper;
import com.serge.reminder.repository.RemindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RemindService {
    private final RemindRepository remindRepository;
    private final RemindReadMsMapper remindReadMsMapper;
    private final RemindCreateEditMsMapper remindCreateEditMsMapper;

    public List<RemindReadDto> findAll() {
        return remindRepository.findAll().stream()
                .map(remindReadMsMapper::map).toList();
    }

    public Optional<RemindReadDto> findById(Long id) {
        return remindRepository.findById(id)
                .map(remindReadMsMapper::map);
    }

    @Transactional
    public RemindReadDto create(RemindCreateEditDto remindCreateEditDto) {
        return Optional.of(remindCreateEditDto)
                .map(remindCreateEditMsMapper::map)
                .map(remindRepository::save)
                .map(remindReadMsMapper::map)
                .orElseThrow();

    }

    @Transactional
    public Optional<RemindReadDto> update(Long id, RemindCreateEditDto remindCreateEditDto) {
        return remindRepository.findById(id)
                .map(entity -> remindCreateEditMsMapper.map(remindCreateEditDto, entity))
                .map(remindRepository::saveAndFlush)
                .map(remindReadMsMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return remindRepository.findById(id)
                .map(entity -> {
                    remindRepository.delete(entity);
                    remindRepository.flush();
                    return true;
                }).orElse(false);
    }
}
