package com.sparta.sparta.scheduleapp.service;

import com.sparta.sparta.scheduleapp.dao.ScheduleDAO;
import com.sparta.sparta.scheduleapp.dto.ScheduleRequestDTO;
import com.sparta.sparta.scheduleapp.dto.ScheduleResponseDTO;
import com.sparta.sparta.scheduleapp.entity.Schedule;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleService {

    private final ScheduleDAO scheduleDAO = new ScheduleDAO();

    public void createSchedule(ScheduleRequestDTO requestDTO) throws SQLException {
        Schedule schedule = new Schedule(null, requestDTO.getTodo(), requestDTO.getAuthor(), requestDTO.getPassword(), LocalDateTime.now(), LocalDateTime.now());
        scheduleDAO.createSchedule(schedule);
    }

    public List<ScheduleResponseDTO> getAllSchedules() throws SQLException {
        List<Schedule> scheduleList = scheduleDAO.getAllSchedules();
        return scheduleList.stream()
                .map(schedule -> new ScheduleResponseDTO(
                        schedule.getId(),
                        schedule.getTodo(),
                        schedule.getAuthor(),
                        schedule.getCreatedAt(),
                        schedule.getUpdatedAt()))
                .collect(Collectors.toList());
    }

    public ScheduleResponseDTO getScheduleById(Long id) throws SQLException {
        Schedule schedule = scheduleDAO.getScheduleById(id);
        if (schedule == null) {
            return null; // ID가 없으면 null 반환
        }
        return new ScheduleResponseDTO(schedule.getId(), schedule.getTodo(), schedule.getAuthor(), schedule.getCreatedAt(), schedule.getUpdatedAt());
    }

    public void updateSchedule(Long id, ScheduleRequestDTO requestDTO) throws SQLException {
        Schedule schedule = new Schedule(id, requestDTO.getTodo(), requestDTO.getAuthor(), requestDTO.getPassword(), null, LocalDateTime.now());
        scheduleDAO.updateSchedule(schedule, requestDTO.getPassword());
    }

    public void deleteSchedule(Long id, String password) throws SQLException {
        scheduleDAO.deleteSchedule(id, password);
    }
}
