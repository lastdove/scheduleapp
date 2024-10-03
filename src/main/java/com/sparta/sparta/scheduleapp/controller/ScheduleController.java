package com.sparta.sparta.scheduleapp.controller;

import com.sparta.sparta.scheduleapp.dto.ScheduleRequestDTO;
import com.sparta.sparta.scheduleapp.dto.ScheduleResponseDTO;
import com.sparta.sparta.scheduleapp.service.ScheduleService;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public void createSchedule(@RequestBody ScheduleRequestDTO requestDTO) throws SQLException {
        scheduleService.createSchedule(requestDTO);
    }

    @GetMapping
    public List<ScheduleResponseDTO> getAllSchedules() throws SQLException {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/{id}")
    public ScheduleResponseDTO getScheduleById(@PathVariable Long id) throws SQLException {
        return scheduleService.getScheduleById(id);
    }

    @PutMapping("/{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDTO requestDTO) throws SQLException {
        scheduleService.updateSchedule(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id, @RequestParam String password) throws SQLException {
        scheduleService.deleteSchedule(id, password);
    }
}