package org.example;

import org.example.shops.Shop1;
import org.example.shops.Shop2;
import org.example.shops.Shop3;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadCalculator {
    Shop1 shop1;
    Shop2 shop2;
    Shop3 shop3;

    AtomicLong money = new AtomicLong(0);

    public ThreadCalculator(Shop1 shop1, Shop2 shop2, Shop3 shop3) throws InterruptedException {
        this.shop1 = shop1;
        this.shop2 = shop2;
        this.shop3 = shop3;
        countBalanceUsingThreads();
    }

    public AtomicLong getMoney() {
        return money;
    }

    private void countBalanceUsingThreads() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (Integer item : shop1.getBalance()) {
                money.addAndGet(item);
            }
        });
        Thread thread2 = new Thread(() -> {
            for (Integer item : shop2.getBalance()) {
                money.addAndGet(item);
            }
        });
        Thread thread3 = new Thread(() -> {
            for (Integer item : shop3.getBalance()) {
                money.addAndGet(item);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread3.join();
        thread2.join();
        thread1.join();
    }

}
