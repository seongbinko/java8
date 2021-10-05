package com.example.java8to11.completablefuture_nine;

public class App_thread {

    public static void main(String[] args) throws InterruptedException {
//        HelloThread helloThread = new HelloThread();
//        helloThread.start();
//        System.out.println("hello : " + Thread.currentThread().getName());

        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("world : " + Thread.currentThread().getName());
//            while(true) {
//                System.out.println("Thread: " + Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    System.out.println("exit!");
//                    return; // 종료한다.
//                }
//            }
            System.out.println("Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw  new IllegalStateException(e);
            }
        });
        thread.start();
        System.out.println("hello : " + Thread.currentThread().getName());

//        Thread.sleep(3000L);
//        thread.interrupt();
        thread.join(); // Thread가 끝날때 까지 (3초)간 대기한다.
        System.out.println(thread + " is finished");
    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            System.out.println("world : " + Thread.currentThread().getName());
        }
    }
}
