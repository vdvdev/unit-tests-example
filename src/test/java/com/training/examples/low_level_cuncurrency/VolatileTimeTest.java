package com.training.examples.low_level_cuncurrency;

import org.junit.Test;

public class VolatileTimeTest {

    int anInt = 0;
    volatile int volatileInt = 0;

    @Test
    public void volatileAndNotDifference(){
        long t1 = System.currentTimeMillis();

        for(int k = 0; k<100_000_000;k++){
            anInt = anInt * anInt;
        }

        long t2 = System.currentTimeMillis();

        for(int k = 0; k<100_000_000;k++){
            volatileInt = volatileInt * volatileInt;
        }

        long t3 = System.currentTimeMillis();

        System.out.printf("\nwith not volatile time is %d" +
                "\nwith volatile time is %s", t2-t1, t3-t2);
    }
}
