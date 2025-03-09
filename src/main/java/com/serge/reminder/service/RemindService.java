package com.serge.reminder.service;

import com.serge.reminder.dto.RemindCreateEditDto;
import com.serge.reminder.dto.RemindReadDto;
import com.serge.reminder.mapper.RemindCreateEditMapper;
import com.serge.reminder.mapper.RemindReadMapper;
import com.serge.reminder.repository.RemindRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RemindService {
    private final RemindRepository remindRepository;
    private final RemindReadMapper remindReadMapper;
    private final RemindCreateEditMapper remindCreateEditMapper;

    public List<RemindReadDto> findAll() {
        return remindRepository.findAll().stream()
                .map(remindReadMapper::map).toList();
    }

    public Optional<RemindReadDto> findById(Long id) {
        return remindRepository.findById(id)
                .map(remindReadMapper::map);
    }

    @Transactional
    public RemindReadDto create(RemindCreateEditDto remindCreateEditDto) {
        return Optional.of(remindCreateEditDto)
                .map(remindCreateEditMapper::map)
                .map(remindRepository::save)
                .map(remindReadMapper::map)
                .orElseThrow();

    }

    @Transactional
    public Optional<RemindReadDto> update(Long id, RemindCreateEditDto remindCreateEditDto) {
        return remindRepository.findById(id)
                .map(entity -> remindCreateEditMapper.map(remindCreateEditDto, entity))
                .map(remindRepository::saveAndFlush)
                .map(remindReadMapper::map);
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
    public Page<RemindReadDto> findAll(Pageable pageable) {
        return remindRepository.findAll(pageable)
                .map(remindReadMapper::map);
    }
}
