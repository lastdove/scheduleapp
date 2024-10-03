package com.sparta.sparta.scheduleapp.entity;

import java.time.LocalDateTime;

public class Schedule {
    private Long id;               // 일정 ID
    private String todo;           // 할 일
    private String author;       // 작성자명
    private String password;       // 비밀번호
    private LocalDateTime createdAt; // 작성일
    private LocalDateTime updatedAt; // 수정일

    // 기본 생성자
    public Schedule() {}

    // 모든 필드를 초기화하는 생성자
    public Schedule(Long id, String todo, String author, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.todo = todo;
        this.author = author;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter 및 Setter 메서드
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
