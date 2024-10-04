package com.sparta.sparta.scheduleapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleResponseDTO {
    private Long id;
    private String todo;
    private String author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt; 
}
