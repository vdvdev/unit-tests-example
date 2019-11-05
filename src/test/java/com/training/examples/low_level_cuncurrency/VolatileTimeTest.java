package com.training.examples.low_level_cuncurrency;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class VolatileTimeTest {

    int anInt = 0;
    volatile int volatileInt = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void volatileAndNotDifference(){
        long t1 = System.currentTimeMillis();

        for(int k = 0; k<100_000_000;k++){
            anInt++;
        }

        long t2 = System.currentTimeMillis();

        for(int k = 0; k<100_000_000;k++){
            volatileInt++;
        }

        long t3 = System.currentTimeMillis();

        for(int k = 0; k<100_000_000;k++){
            atomicInteger.incrementAndGet();
        }

        long t4 = System.currentTimeMillis();

        System.out.printf("\nwith not volatile time is %d" +
                "\nwith volatile time is %s" +
                "\nwith atomic time is %s", t2-t1, t3-t2, t4-t3);
    }
}
