package com.sparta.sparta.scheduleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleRequestDTO {
    private final String todo;
    private final String author;
    private final String password;
}