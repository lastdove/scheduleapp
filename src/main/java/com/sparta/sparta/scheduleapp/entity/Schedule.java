package com.sparta.sparta.scheduleapp.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Schedule {
    private Long id;               // 일정 ID
    private String todo;           // 할 일
    private String author;       // 작성자명
    private String password;       // 비밀번호
    private LocalDateTime createdAt; // 작성일
    private LocalDateTime updatedAt; // 수정일
}