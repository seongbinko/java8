package com.example.java8to11.functional_one;

@FunctionalInterface
public interface RunSomething {
    void doIt();

    static void printName() {
        System.out.println("KSB");
    }

    default void printAge() {
        System.out.println("28");
    }
}
