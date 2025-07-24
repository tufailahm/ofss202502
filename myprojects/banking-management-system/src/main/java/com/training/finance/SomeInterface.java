package com.training.finance;

@FunctionalInterface
public interface SomeInterface {
  public static final int SOME_VALUE = 123;
  void someAbstractMethod1();
  public default void someDefaultMethod() { }
  private void somePrivateMethod() { }
  public static void someStaticMethod() { }
}
