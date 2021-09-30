package com.example.java8to11.stream_pipeline_five;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("ko");
        names.add("seongbin");
        names.add("bcd");
        names.add("zoo");

        System.out.println("========== single Thread =========");
        List<String> collect = names.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("========== multi Thread ========");
        List<String> collect1 = names.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println("===============================");
        collect.forEach(System.out::println);

    }
}
