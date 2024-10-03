package com.sparta.sparta.scheduleapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleResponseDTO {
    private Long id; // ID of the schedule
    private String todo; // Task description
    private String author; // Author's name
    private LocalDateTime createdAt; // Creation date and time
    private LocalDateTime updatedAt; // Last update date and time
}
