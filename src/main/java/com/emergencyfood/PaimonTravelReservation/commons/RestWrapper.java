package com.emergencyfood.PaimonTravelReservation.commons;


import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RestWrapper {

    /**
     * 是否临时禁用
     */
    boolean disabled() default false;
}