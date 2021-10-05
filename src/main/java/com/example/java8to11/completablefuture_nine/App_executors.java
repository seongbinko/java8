package com.example.java8to11.completablefuture_nine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class App_executors {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Thread  = " + Thread.currentThread().getName());
//            }
//        });
        
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(getRunnable("hello"));
//        executorService.submit(getRunnable("seongbin"));
//        executorService.submit(getRunnable("java"));
//        executorService.submit(getRunnable("spring"));
//        executorService.submit(getRunnable("Thread"));
//        executorService.shutdown();

//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        executorService.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(getRunnable("Hello"), 3, 2, TimeUnit.SECONDS);

//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Callable<String> hello = () -> {
//            Thread.sleep(2000L);
//            return "Hello";
//        };
//        Future<String> helloFuture = executorService.submit(hello);
//        System.out.println(helloFuture.isDone());
//        System.out.println("Started!");
//
////        helloFuture.cancel(true); // true false 관계 없이 이미 취소된 작업에 대해서 get을 할 수 없다. CancellationExecption 발생
//
//        helloFuture.get(); // 블록킹 콜 return된 string hello를 가진다.
//
//        System.out.println(helloFuture.isDone());
//        System.out.println("End!!");
//        executorService.shutdown();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<String> hello = () -> {
            Thread.sleep(1000L);
            return "Hello";
        };
        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };
        Callable<String> spring = () -> {
            Thread.sleep(2000L);
            return "spring";
        };
//        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hello, java, spring));
//        for (Future<String> f : futures) {
//            System.out.println(f.get());
//        }

        String s = executorService.invokeAny(Arrays.asList(hello, java, spring));
        System.out.println(s);
        executorService.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
