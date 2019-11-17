package com.training.examples.low_level_cuncurrency;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class SynchronizedTest {

    int count = 0;
    AtomicInteger atomic = new AtomicInteger();

    void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    synchronized void incrementSync() {
        IntStream.range(0, 10000).forEach(i -> count++);
    }

    void incrementAtomic() {
        IntStream.range(0, 10000).forEach(i -> atomic.incrementAndGet());
    }

    @Test
    public void notSync() throws InterruptedException {
        var exec = Executors.newFixedThreadPool(5);
        IntStream.range(1, 11).forEach(i -> exec.execute(this::increment));
        Thread.sleep(1000);
        System.out.println(count);
    }

    @Test
    public void sync() throws InterruptedException {
        var exec = Executors.newFixedThreadPool(5);
        IntStream.range(1, 11).forEach(i -> exec.execute(this::incrementSync));
        Thread.sleep(1000);
        System.out.println(count);
    }

    @Test
    public void atomic() throws InterruptedException {
        var exec = Executors.newFixedThreadPool(5);
        IntStream.range(1, 11).forEach(i -> exec.execute(this::incrementAtomic));
        Thread.sleep(1000);
        System.out.println(atomic.get());
    }
}
