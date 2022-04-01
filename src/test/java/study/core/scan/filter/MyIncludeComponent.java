package study.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyIncludeComponent {
}
