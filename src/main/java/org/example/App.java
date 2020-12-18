package org.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    private int THREADS_NUMBER = 3;

    public static void main(String[] args) throws InterruptedException {
        App myApp = new App();
        LongAdder balance = new LongAdder();
        List<Shop> shopList = Stream.of(new Shop("Магазин1"),
                new Shop("Магазин2"),
                new Shop("Магазин3"))
                .collect(Collectors.toList());

        ExecutorService executorService = Executors.newFixedThreadPool(myApp.THREADS_NUMBER);//создаём исполнитель

        shopList.stream()
                .map(Shop::getBalance)
                .forEach(shopBalance -> shopBalance
                        .forEach(item -> executorService.submit(() -> balance.add(item))));

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("\nРезультат: " + balance.sum());
    }
}
