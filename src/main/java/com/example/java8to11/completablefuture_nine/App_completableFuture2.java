package com.example.java8to11.completablefuture_nine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class App_completableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        boolean throwsError = false;
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if(throwsError) {
                throw new IllegalStateException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).handle((result, ex) -> {
            if(ex != null) {
                System.out.println(ex);
                return "Error!";
            }
            return result;
        });
        System.out.println(hello.get());
//        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
//            System.out.println("World " + Thread.currentThread().getName());
//            return "World";
//        });
//        CompletableFuture<String> future = hello.thenCombine(world, (h, w) -> h + " " + w);
//        System.out.println(future.get());

//        CompletableFuture<String> future = hello.thenCompose(App_completableFuture2::getWorld);
//        System.out.println(future.get());

//        List<CompletableFuture> futures = Arrays.asList(hello, world);
//        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
//        CompletableFuture<List<Object>> result = CompletableFuture.allOf(futuresArray)
//                .thenApply(v -> {
//                    return futures.stream()
//                            .map(CompletableFuture::join)
//                            .collect(Collectors.toList()); // f.get()은 checkedException을 발생 join은 unchecked 예제니까 join
//                });
//        result.get().forEach(System.out::println);

//        CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
//        future.get();


    }

//    private static CompletableFuture<String> getWorld(String message) {
//        return CompletableFuture.supplyAsync(() -> {
//            System.out.println("World " + Thread.currentThread().getName());
//            return message + " World";
//        });
//    }
}
