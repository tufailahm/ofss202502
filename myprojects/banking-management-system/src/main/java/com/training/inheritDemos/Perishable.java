package com.training.inheritDemos;

import java.time.Period;

public interface Perishable {
  public static final Period MAX_PERIOD = Period.ofDays(5);
  void perish();
  boolean isPerished();
  public default boolean verifyPeriod(Period p) {
    return comparePeriod(p) < 0;
  }
  private int comparePeriod(Period p) {
    return p.getDays() - MAX_PERIOD.getDays();
  }
  public static int getMaxPeriodDays() {
    return MAX_PERIOD.getDays();
  }
}

interface Radio
{
  void play();
  void pause();
}

@FunctionalInterface
interface ModernRadio  {
  void rewind();
}
class OnePlus
{

}