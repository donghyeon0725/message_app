package app.messages.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 어노테이션 생성하기
 *
 * 1. @Target 의 속성으로 적용가능한 어노테이션의 위치 정하기
 * 2. @Retention 의 속성으로 어노테이션이 작동할 시점을 정하기
 * */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityCheck {
}
