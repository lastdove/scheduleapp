package com.sparta.sparta.scheduleapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ScheduleRequestDTO {
    private String todo;
    private String author;
    private String password;
}