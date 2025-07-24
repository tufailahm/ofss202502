package com.hello;

import java.util.concurrent.*;

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        Callable<String> t = () -> {
            /* perform concurrent actions */
            System.out.println("Call called");
            return "some value";
        };
        ExecutorService es = Executors.newFixedThreadPool(10);
        Future<String> result = es.submit(t);
        try {
            String value = result.get(10, TimeUnit.SECONDS);
        } catch(Exception e) { /* see notes for details */ }


    }
}
