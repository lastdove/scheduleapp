package com.sparta.sparta.scheduleapp.dao;

import com.sparta.sparta.scheduleapp.entity.Schedule;
import com.sparta.sparta.scheduleapp.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {

    public void createSchedule(Schedule schedule) throws SQLException {
        String sql = "INSERT INTO schedules (todo, author, password, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, schedule.getTodo());
            pstmt.setString(2, schedule.getAuthor());
            pstmt.setString(3, schedule.getPassword());
            pstmt.setTimestamp(4, Timestamp.valueOf(schedule.getCreatedAt()));
            pstmt.setTimestamp(5, Timestamp.valueOf(schedule.getUpdatedAt()));
            pstmt.executeUpdate();
        }
    }

    public List<Schedule> getAllSchedules() throws SQLException {
        String sql = "SELECT * FROM schedules ORDER BY updated_at DESC";
        List<Schedule> scheduleList = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getLong("id"),
                        rs.getString("todo"),
                        rs.getString("author"),
                        null,  // 비밀번호 제외
                        rs.getTimestamp("created_at").toLocalDateTime(),
                        rs.getTimestamp("updated_at").toLocalDateTime()
                );
                scheduleList.add(schedule);
            }
        }
        return scheduleList;
    }

    public Schedule getScheduleById(Long id) throws SQLException {
        String sql = "SELECT * FROM schedules WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Schedule(
                            rs.getLong("id"),
                            rs.getString("todo"),
                            rs.getString("author"),
                            null,  // 비밀번호 제외
                            rs.getTimestamp("created_at").toLocalDateTime(),
                            rs.getTimestamp("updated_at").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    public void updateSchedule(Schedule schedule, String password) throws SQLException {
        String sql = "UPDATE schedules SET todo = ?, author = ?, updated_at = ? WHERE id = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, schedule.getTodo());
            pstmt.setString(2, schedule.getAuthor());
            pstmt.setTimestamp(3, Timestamp.valueOf(schedule.getUpdatedAt()));
            pstmt.setLong(4, schedule.getId());
            pstmt.setString(5, password);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("일정을 수정할 수 없습니다. 비밀번호를 확인하세요.");
            }
        }
    }

    public void deleteSchedule(Long id, String password) throws SQLException {
        String sql = "DELETE FROM schedules WHERE id = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            pstmt.setString(2, password);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("일정을 삭제할 수 없습니다. 비밀번호를 확인하세요.");
            }
        }
    }
}
