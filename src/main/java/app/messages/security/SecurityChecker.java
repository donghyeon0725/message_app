package app.messages.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Aspect 컴포넌트로 등록
 * @Component 으로 스캔
 *
 * 1. Aspect 모듈로 등록
 * 2. 포인트컷 정하기 => 선택할 메소드를 한번에 표현식으로 선택
 *        - 또는 어노테이션을 만든 다음 어노테이션만 선택 가능
 * 3. @Before, @After, @Around 어노테이션 등등으로 조인포인트(실행시점) 정하기
 * */
@Aspect
@Component
public class SecurityChecker {

  private static final Logger logger = LoggerFactory.getLogger(SecurityChecker.class);

  @Pointcut("@annotation(SecurityCheck)")
  public void checkMethodSecurity() {}

  @Around("checkMethodSecurity()")
  public Object checkSecurity (ProceedingJoinPoint joinPoint) throws Throwable {
    logger.debug("Checking method security...");
    // TODO Implement security check logics here
    Object result = joinPoint.proceed();
    return result;
  }
}
