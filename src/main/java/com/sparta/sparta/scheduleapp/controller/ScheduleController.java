package com.sparta.sparta.scheduleapp.controller;

import com.sparta.sparta.scheduleapp.dto.ScheduleRequestDTO;
import com.sparta.sparta.scheduleapp.dto.ScheduleResponseDTO;
import com.sparta.sparta.scheduleapp.service.ScheduleService;

import java.sql.SQLException;
import java.util.List;

public class ScheduleController {

    private final ScheduleService scheduleService = new ScheduleService();

    public void createSchedule(ScheduleRequestDTO requestDTO) throws SQLException {
        scheduleService.createSchedule(requestDTO);
    }

    public List<ScheduleResponseDTO> getAllSchedules() throws SQLException {
        return scheduleService.getAllSchedules();
    }

    public ScheduleResponseDTO getScheduleById(Long id) throws SQLException {
        return scheduleService.getScheduleById(id);
    }

    public void updateSchedule(Long id, ScheduleRequestDTO requestDTO) throws SQLException {
        scheduleService.updateSchedule(id, requestDTO);
    }

    public void deleteSchedule(Long id, String password) throws SQLException {
        scheduleService.deleteSchedule(id, password);
    }
}
