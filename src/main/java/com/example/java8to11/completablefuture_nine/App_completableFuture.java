package com.example.java8to11.completablefuture_nine;

import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App_completableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("seongbin");
        System.out.println(future.get());

        CompletableFuture<String> future1 = CompletableFuture.completedFuture("seongbin");
        System.out.println(future1.get());

        CompletableFuture<Void> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() ->     System.out.println(Thread.currentThread().getName()));
        System.out.println(future2.get());

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService);
        //  Hello ForkJoinPool.commonPool-worker-3 -> Hello pool-1-thread-1

    }
}
