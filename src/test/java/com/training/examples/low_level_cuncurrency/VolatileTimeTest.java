package com.training.examples.low_level_cuncurrency;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTimeTest {

  int anInt = 0;
  volatile int volatileInt = 0;
  AtomicInteger atomicInteger = new AtomicInteger(0);

  @Test
  public void volatileAndNotDifference() {
    long t1 = System.currentTimeMillis();

    for (int k = 0; k < 100_000_000; k++) {
      anInt++;
    }

    long t2 = System.currentTimeMillis();

    for (int k = 0; k < 100_000_000; k++) {
      volatileInt++;
    }

    long t3 = System.currentTimeMillis();

    for (int k = 0; k < 100_000_000; k++) {
      atomicInteger.incrementAndGet();
    }

    long t4 = System.currentTimeMillis();

    System.out.printf("\nwith not volatile time is %d" +
        "\nwith volatile time is %s" +
        "\nwith atomic time is %s", t2 - t1, t3 - t2, t4 - t3);
  }

  @Test
  public void volatileRaceConditionTest() throws InterruptedException {

    var threadPoolExecutor = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 2; i++) {
      threadPoolExecutor.execute(() -> {
        for (int k = 0; k < 1_000_000; k++) {
          volatileInt += 1;
        }
      });
    }
    threadPoolExecutor.shutdown();
    while (!threadPoolExecutor.isTerminated()){
      Thread.sleep(10);
      System.out.println(volatileInt);
    }
    System.out.println(volatileInt);

  }

  @Test
  public void notVolatileRaceConditionTest() throws InterruptedException {

    var threadPoolExecutor = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 2; i++) {
      threadPoolExecutor.execute(() -> {
        for (int j = 0; j < 1_000_000; j++) {
          anInt += 1;
        }
      });
    }
    threadPoolExecutor.shutdown();
    while (!threadPoolExecutor.isTerminated()){
      Thread.sleep(10);
      System.out.println(anInt);
    }
    System.out.println(anInt);

  }

}
