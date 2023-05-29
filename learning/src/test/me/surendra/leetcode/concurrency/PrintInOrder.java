package me.surendra.leetcode.concurrency;

import java.util.concurrent.Semaphore;

// https://leetcode.com/problems/print-in-order/
public class PrintInOrder extends Thread {

    Semaphore run2, run3;

    public PrintInOrder() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        run2.acquire();
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        run3.acquire();
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException
    {

        final PrintInOrder printInOrder = new PrintInOrder();
        printInOrder.run();
        printInOrder.first(() -> System.out.println("first"));
        printInOrder.third(() -> System.out.println("third"));
        printInOrder.second(() -> System.out.println("second"));
    }

}


