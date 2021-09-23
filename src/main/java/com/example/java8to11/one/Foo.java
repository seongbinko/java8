package com.example.java8to11.one;

import java.util.function.*;

public class Foo {
    public static void main(String[] args) {
        // 익명 클래스
        RunSomething runSomething = new RunSomething() {
            @Override
            public void doIt() {
                System.out.println("hello");
            }
        };

        RunSomething runSomething1 = () -> System.out.println("hello lambda");

        // 한줄이 아닐 때
        RunSomething runSomething2 = () -> {
            System.out.println("hello");
            System.out.println("hello2");
        };
        runSomething2.doIt();

        // 순수함수로 볼 수 없는 경우
        // int baseNumber = 10; 이곳에 선언하면 컴파일 에러
        RunSomething2 runSomething3 = new RunSomething2() {
            int baseNumber = 10;

            @Override
            public int doIt(int number) {
                baseNumber ++;
                return number + baseNumber;
            }
        };
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(10));

        Function<Integer, Integer> plus10 = (i) -> i + 10;
        Function<Integer, Integer> multiply2 = (i) -> i * 2;

        // 조합가능
        Function<Integer, Integer> multipy2AndPlus10 = plus10.compose(multiply2);
        System.out.println(multipy2AndPlus10.apply(2)); // 2 * 2 + 10

        BiFunction<Integer, String, Integer> biFunction = (i,s) -> {
          return i + Integer.valueOf(s);
        };
        System.out.println(biFunction.apply(10, "5"));

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        Supplier<Integer> get10 = () -> 20;
        System.out.println(get10.get());

        Predicate<String> startsWithSeongbin = (s) -> s.startsWith("seongbin");
        System.out.println(startsWithSeongbin.test("seongbin93"));

        UnaryOperator<Integer> plus100 = (i) -> i + 100;
        System.out.println("plus100.apply(10) = " + plus100.apply(10));

        BinaryOperator<Integer> binaryOperator = (i,s) -> {
            return i + s;
        };
        System.out.println("binaryOperator.apply(10,90) = " + binaryOperator.apply(10,90));

        // 람다 표현식
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10; // final을 생략할수 있는 경우: 이 변수가 사실상 파이널인 경우, 이펙티브 파이널인 경우 생략가능(만약 ++값은 증감이 있다면 원래는 없었던 컴파일에서 에러가 발생)
        //baseNumber++; error: Variable used in lambda expression should be final or effectively final

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11;
                System.out.println("LocalClass" + baseNumber); // 11
            }
        }
        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) { // integer라는 변수명이었으면 아래 baseNumber가 위에 baseNumber를 따르지만, 현재와 같이 baseNumber로 설정하면 파라미터의 값을 따른다.
                System.out.println(baseNumber);
            }
        };

        // 람다 (위 두개와 람다 표현식과의 차이점) 람다는 스콥이  run 바로 밑 baseNumber와 같은 Scope이다. 즉 파라미터 (i)를 baseNumber로 설정할 수 없다.
        // error: Variable 'baseNumber' is already defined in the scope
        IntConsumer printInt = (i) -> {
                System.out.println(i + baseNumber);
        };
        printInt.accept(10);
    }

}
