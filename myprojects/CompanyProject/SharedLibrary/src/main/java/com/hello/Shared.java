package com.hello;

public class Shared {
  public int x;
  public  volatile  int y;

  @Override
  public String toString() {
    return "Shared{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }

  public static void main(String[] args) {
    Shared s = new Shared();
    new Thread(() -> {
      while(s.y < 1){
        int x = s.x;
        System.out.println(Thread.currentThread().getName()+ ""+ s);
      }
    }).start();
    new Thread(() -> {
      s.x = 2;
      s.y = 2;
      System.out.println(Thread.currentThread().getName()+ ""+ s);
    }).start();

  }
}
