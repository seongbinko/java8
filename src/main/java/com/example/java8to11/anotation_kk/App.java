package com.example.java8to11.anotation_kk;

import java.util.Arrays;

@Chicken("양념")
@Chicken("후라이드")
public class App {
    public static void main(String[] args) {
        
        Chicken[] chickens = App.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        ChickenContainer chickenContainer = App.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(
                c -> {
                    System.out.println(c.value());
                }
        );
    }
//    static class FeelsLikeChicken<@Chicken T> {
//        public static <@Chicken C> void print(C c) {
//            System.out.println(c);
//        }
//    }
}
