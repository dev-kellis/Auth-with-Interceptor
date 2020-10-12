package kr.kellis.aawithinterceptor.app.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@LoginRequired
public @interface AdminOnly {
}
