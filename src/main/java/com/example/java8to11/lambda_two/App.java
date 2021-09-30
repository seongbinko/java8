package com.example.java8to11.lambda_two;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * 메소드 레퍼런스
 */
public class App {
    public static void main(String[] args) {
//        UnaryOperator<String> hi = (s) -> "hi " + s; 동일한 함수형 인터페이스

        //1 스태틱 메소드 참조
        UnaryOperator<String> hi = Greeting::hi;
        //2 특정 객체의 인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;

        //3 임의 객체의 인스턴스 메소드 참조
        String[] names = {"ABC", "abb", "spring", "java"};
//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println("names = " + Arrays.toString(names));

        //4 생성자 참조
        Supplier<Greeting> newGreeting = Greeting::new; // 생성자 참조
        Greeting greeting1 = newGreeting.get();

        Function<String, Greeting> greeting3 = Greeting::new; // 파라미터를 받는 생성자를 참조

    }
}
