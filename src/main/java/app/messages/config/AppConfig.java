package app.messages.config;

import app.messages.web.AuditingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@ComponentScan("app.messages")
@EnableTransactionManagement
public class AppConfig {

  private DataSource dataSource;

  public AppConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  /**
   * 필터 등록하기
   *
   * 1. AuditingFilter 필터를 만든다.
   * 2. FilterRegistrationBean 타입에 제네릭으로 AuditingFilter 필터 등록 빈을 생성한다.
   * 3. 필터, 순서, 매핑할 url 을 정하고 등록빈인  FilterRegistrationBean 리턴
   * */
  @Bean
  public FilterRegistrationBean<AuditingFilter> auditingFilterRegistrationBean() {
    FilterRegistrationBean<AuditingFilter> registration = new FilterRegistrationBean<>();
    AuditingFilter filter = new AuditingFilter();
    registration.setFilter(filter);
    registration.setOrder(Integer.MAX_VALUE);
    registration.setUrlPatterns(Arrays.asList("/messages/*"));
    return registration;
  }

  /**
   * DB 세션 관리하기
   *
   * 1. FactoryBean 인터페이스를 구현한 클래스 중 하나(sessionFactoryBean)를 객체로 생성
   * 2. 스프링 부트에서 자동으로 DB와 연결 해놓은 커넥션 풀에서 dataSource 를 받을 수 있게 DataSource 필드와 생성자 만들기
   * 3. **매핑 해줄 Entity가 있는 경로** 스캔 가능하게 setPackagesToScan 에 경로 지정 (하이버네티스가 엔티티 클래스를 통해 매핑관계를 가질 수 있게함)
   * 4. sessionFactoryBean 리턴
   * */
  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource);
    sessionFactoryBean.setPackagesToScan("app.messages");
    return sessionFactoryBean;
  }

  /**
   * 트랜잭션 관리하기
   *
   * 1. HibernateTransactionManager 생성
   * 2. 현재 사용하는 (위에서 작성한 메소드인) sessionFactoryBean 을 가져다가 HibernateTransactionManager 에 등록 후 매니저 리턴
   * */
  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager =
      new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }
}
