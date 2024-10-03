package com.sparta.sparta;  // 패키지 이름은 실제 프로젝트의 패키지 구조에 맞게 수정하세요.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Spring Boot 애플리케이션의 자동 설정 및 컴포넌트 스캔을 활성화
public class ScheduleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduleAppApplication.class, args);  // 애플리케이션 실행
    }
}
