package com.sparta.sparta.scheduleapp.dto;

public class ScheduleRequestDTO {
    private final String todo;
    private final String author;
    private final String password;

    public ScheduleRequestDTO(String todo, String author, String password) {
        this.todo = todo;
        this.author = author;
        this.password = password;
    }

    public String getTodo() {
        return todo;
    }

    public String getAuthor() {
        return author;
    }

    public String getPassword() {
        return password;
    }
}
