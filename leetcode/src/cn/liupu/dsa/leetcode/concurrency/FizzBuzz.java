package cn.liupu.dsa.leetcode.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            int count = atomicInteger.get();
            if (count > n) {
                return;
            }
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
                atomicInteger.incrementAndGet();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            int count = atomicInteger.get();
            if (count > n) {
                return;
            }
            if (count % 3 != 0 && count % 5 == 0) {
                printBuzz.run();
                atomicInteger.incrementAndGet();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            int count = atomicInteger.get();
            if (count > n) {
                return;
            }
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
                atomicInteger.incrementAndGet();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            int count = atomicInteger.get();
            if (count > n) {
                return;
            }
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
                atomicInteger.incrementAndGet();
            }
        }
    }
}