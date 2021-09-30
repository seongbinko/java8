package com.example.java8to11.optional_seven;

import com.example.java8to11.stream_api_six.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<com.example.java8to11.optional_seven.OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new com.example.java8to11.optional_seven.OnlineClass(1, "spring boot", true));
        springClasses.add(new com.example.java8to11.optional_seven.OnlineClass(2, "rest api development", false));

        Optional<com.example.java8to11.optional_seven.OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
//        OnlineClass onlineClass1 = optional.get(); 겟 지양

//        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

//        OnlineClass onlineClass = optional.orElse(createNewClass());

//        OnlineClass onlineClass = optional.orElseGet(() -> createNewClass());

        Optional<com.example.java8to11.optional_seven.OnlineClass> onlineClass =
                optional.filter(oc -> !oc.isClosed());
        System.out.println("onlineClass.getTitle() = " + onlineClass.isPresent());

        Optional<Integer> integer = optional.map(com.example.java8to11.optional_seven.OnlineClass::getId);
        System.out.println(integer.isPresent());

        Optional<Progress> progress = optional.flatMap(com.example.java8to11.optional_seven.OnlineClass::getProgress);

        Optional<Optional<Progress>> progress1 = optional.map(com.example.java8to11.optional_seven.OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow();

    }

    private static OnlineClass createNewClass() {
        System.out.println("creating new online class"); // 의도하지 않던 의도 하던 무조건 실행
        return new OnlineClass(10, "New class", false);
    }
}
