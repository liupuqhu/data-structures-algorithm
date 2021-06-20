package cn.liupu.dsa.leetcode.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Foo3 {

    private Lock lock;

    private boolean oneDone;

    private boolean twoDone;

    private Condition one;

    private Condition two;

    public Foo3() {
        lock = new ReentrantLock();
        oneDone = false;
        twoDone = false;
        one = lock.newCondition();
        two = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            oneDone = false;
            one.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!oneDone) {
                one.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            twoDone = true;
            two.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!twoDone) {
                two.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

        } finally {
            lock.unlock();
        }
    }
}