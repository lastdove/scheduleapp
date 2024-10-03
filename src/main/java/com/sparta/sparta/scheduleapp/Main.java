package com.sparta.sparta.scheduleapp;

import com.sparta.sparta.scheduleapp.controller.ScheduleController;
import com.sparta.sparta.scheduleapp.dto.ScheduleRequestDTO;
import com.sparta.sparta.scheduleapp.dto.ScheduleResponseDTO;

import java.sql.SQLException;
import java.util.*;

public class Main {

    private static final ScheduleController controller = new ScheduleController();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        while (true) {
            System.out.println("1. 일정 생성  2. 일정 조회  3. 일정 수정  4. 일정 삭제  5. 전체 일정 조회  0. 종료");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1 -> createSchedule();
                case 2 -> getSchedule();
                case 3 -> updateSchedule();
                case 4 -> deleteSchedule();
                case 5 -> getAllSchedules();
                case 0 -> {
                    System.out.println("종료합니다.");
                    return; // 프로그램 종료
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void createSchedule() throws SQLException {
        System.out.print("할일 : ");
        String todo = sc.nextLine();
        System.out.print("작성자명 : ");
        String author = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();

        ScheduleRequestDTO dto = new ScheduleRequestDTO(todo, author, password);
        controller.createSchedule(dto);
        System.out.println("일정이 생성되었습니다.");
    }

    private static void getSchedule() throws SQLException {
        System.out.print("조회할 일정의 ID : ");
        Long id = sc.nextLong();
        sc.nextLine(); // 버퍼 비우기
        ScheduleResponseDTO schedule = controller.getScheduleById(id);
        if (schedule != null) {
            System.out.println("일정 정보: " + schedule.getTodo() + " - " + schedule.getAuthor() + " (작성일: " + schedule.getCreatedAt() + ")");
        } else {
            System.out.println("해당 ID의 일정이 없습니다.");
        }
    }

    private static void updateSchedule() throws SQLException {
        System.out.print("수정할 일정의 ID : ");
        Long id = sc.nextLong();
        sc.nextLine(); // 버퍼 비우기
        System.out.print("새로운 할일 : ");
        String todo = sc.nextLine();
        System.out.print("새로운 작성자명 : ");
        String author = sc.nextLine();
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();

        ScheduleRequestDTO dto = new ScheduleRequestDTO(todo, author, password);
        controller.updateSchedule(id, dto);
        System.out.println("일정이 수정되었습니다.");
    }

    private static void deleteSchedule() throws SQLException {
        System.out.print("삭제할 일정의 ID : ");
        Long id = sc.nextLong();
        sc.nextLine(); // 버퍼 비우기
        System.out.print("비밀번호 : ");
        String password = sc.nextLine();

        controller.deleteSchedule(id, password);
        System.out.println("일정이 삭제되었습니다.");
    }

    private static void getAllSchedules() throws SQLException {
        List<ScheduleResponseDTO> schedules = controller.getAllSchedules();
        if (schedules.isEmpty()) {
            System.out.println("등록된 일정이 없습니다.");
        } else {
            for (ScheduleResponseDTO schedule : schedules) {
                System.out.println("일정 ID: " + schedule.getId() + ", 할일: " + schedule.getTodo() + ", 작성자: " + schedule.getAuthor() + ", 작성일: " + schedule.getCreatedAt());
            }
        }
    }
}
