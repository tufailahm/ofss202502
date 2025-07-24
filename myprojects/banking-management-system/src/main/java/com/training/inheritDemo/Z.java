package com.training.inheritDemo;

class W {
    public W() {
        System.out.println("5. W constructor");
    }
	 {
        System.out.println("4. W instance block");
    }
    static {
        System.out.println("1.   W static block");
    }
}
public class Z extends W{
    {
        System.out.println(" 6. Z instance block");
    }
    static {
        System.out.println("2.   Z static block");
    }
    public Z() {
        System.out.println("7. Z constructor");
    }
    public static void main(String args[]) {
        System.out.println("3.   In main");
        new Z();
    }
}