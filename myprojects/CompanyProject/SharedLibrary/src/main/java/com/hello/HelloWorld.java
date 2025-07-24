package com.hello;

public class HelloWorld {

    public void sayHello(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        int numOfHardwareThreads = r.availableProcessors();
        System.out.println(numOfHardwareThreads);

    }
}
