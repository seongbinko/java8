package com.example.java8to11.three;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("seongbin");
        foo.printName();

        foo.printNameUpperCase(); // default method

        Foo.printStaticMethod();
    }
}
