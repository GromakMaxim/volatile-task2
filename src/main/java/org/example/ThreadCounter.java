package org.example;

import java.util.concurrent.atomic.LongAdder;

public class ThreadCounter implements Runnable {

    Shop shop;
    LongAdder balance;

    public ThreadCounter(Shop shop, LongAdder balance) {
        this.shop = shop;
        this.balance = balance;
    }

    @Override
    public void run() {
        shop.getBalance().forEach(balance::add);
        System.out.println(Thread.currentThread().getName());
    }
}
