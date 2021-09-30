package com.example.java8to11.method_four;

import java.util.*;

public class App {
    public static void main(String[] args) {
        String[] arr = {"aeongbin", "bsb", "ko", "zello"};
        List<String> list = Arrays.asList(arr); // fixedSize다.

        List<String> names = new ArrayList<>();
        names.add("aeongbin");
        names.add("bsb");
        names.add("ko");
        names.add("zello");



//        list.forEach(
//                s -> {
//                    System.out.println(s);
//                }
//        );
//        list.forEach(System.out::println);
//        System.out.println("==========================");
//
//        Spliterator<String> spliterator = list.spliterator(); // 쪼갤 수 있는 iterator
//        Spliterator<String> spliterator1 = spliterator.trySplit();
//
//        while (spliterator.tryAdvance(System.out::println));
//        System.out.println("==========================");
//        while (spliterator1.tryAdvance(System.out::println));

//        names.removeIf(s -> s.startsWith("k")); // UnsupportedOperationException: remove
//        names.forEach(System.out::println);

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());

        names.forEach(System.out::println);
    }
}
