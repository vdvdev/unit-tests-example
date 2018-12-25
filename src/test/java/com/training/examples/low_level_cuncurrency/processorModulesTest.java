package com.training.examples.low_level_cuncurrency;

import org.junit.Test;

public class processorModulesTest {

    @Test
    public void differenceInCountTime(){
        double d1 = 0.0;
        double d2 = 0.0;

        long t1 = System.currentTimeMillis();

        for (int k=0; k < 100_000_000; k++){
            d1 = d1 * d1;
            d1 = d1 * d1;
        }

        long t2 = System.currentTimeMillis();

        for (int k=0; k < 100_000_000; k++){
            d1 = d1 * d1;
            d2 = d2 * d2;
        }

        long t3 = System.currentTimeMillis();

        System.out.printf("\nWith one var twice in loop time is %d" +
                "\nWith two var in loop time is %d",t2-t1, t3-t2);
    }
}
