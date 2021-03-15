package app.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;

/**
 * 스프링 부트 시작하기
 *
 * 1. @ContextConfiguration(classes = Application.class) : 이 클래스가 메인 클래스임을 알림 (없을 경우 톰캣이 실행 안될 수도 있음)
 * 2. @SpringBootApplication : 스프링부트를 시작하게 해줌
 * */
@ContextConfiguration(classes = Application.class)
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
