package com.example.java8to11.three;

public interface Foo {

    void printName();


    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printStaticMethod() {
        System.out.println("Foo static method");
    }

    String getName();
}
