package app.messages.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

/**
 * 필터 생성하기
 *
 * 1. GenericFilterBean 를 상속 받는다.
 * 2. 설정 class 에서 설정 빈에 등록한다.
 * 3. doFilter 를 오버라이드 한다.
 * 4. chain.doFilter 를 호출한다.
 * */
public class AuditingFilter extends GenericFilterBean {
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    long start = new Date().getTime();
    chain.doFilter(req, res);
    long elapsed = new Date().getTime() - start;
    logger.debug("Request[uri=" + request.getRequestURI() + ", method=" +
      request.getMethod() + "] completed in " + elapsed + " ms");
  }
}
