package com.training.finance;

class W {
    public W() {
        System.out.println("3. W constructor");
    }
}
public class Z {
    W w = new W();
    {
        System.out.println("4. instance block");
    }
    static {
        System.out.println("1. static block");
    }
    public Z() {
        System.out.println("5. Z constructor");
    }
    public static void main(String args[]) {
        System.out.println("2. In main");
        new Z();
        new Z();
    }
}

