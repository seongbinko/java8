package com.example.java8to11.interface_three;

public class App {
    public static void main(String[] args) {
        Foo foo = new DefaultFoo("seongbin");
        foo.printName();

        foo.printNameUpperCase(); // default method

        Foo.printStaticMethod();
    }
}
