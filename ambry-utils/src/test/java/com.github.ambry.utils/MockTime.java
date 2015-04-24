package com.github.ambry.utils;

/**
 * A mock time class
 */
public class MockTime extends Time {
  public long currentMilliseconds;
  public long currentNanoSeconds;
  public long sleepTimeExpected;

  @Override
  public long milliseconds() {
    return currentMilliseconds;
  }

  @Override
  public long nanoseconds() {
    return currentNanoSeconds;
  }

  @Override
  public void sleep(long ms)
      throws InterruptedException {
    currentMilliseconds += ms;
    if (sleepTimeExpected != ms) {
      throw new IllegalArgumentException();
    }
  }
}