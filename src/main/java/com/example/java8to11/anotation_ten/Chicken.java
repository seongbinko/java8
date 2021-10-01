package com.example.java8to11.anotation_ten;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 리텐션 전략
//@Target(ElementType.TYPE_PARAMETER)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    String value();
}
