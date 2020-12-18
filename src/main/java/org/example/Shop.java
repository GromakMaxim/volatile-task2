package org.example;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shop {
    private final List<Integer> balance;
    private final int VALUES_LIMIT = 1_000_000;
    private final int LOW_LIMIT = 0;
    private final int UPPER_LIMIT = 100;

    private String title;

    public Shop(String title) {
        this.balance = new Random().ints(LOW_LIMIT, UPPER_LIMIT)
                .limit(VALUES_LIMIT)
                .boxed()
                .collect(Collectors.toList());
        this.title = title;
    }

    public List<Integer> getBalance() {
        return balance;
    }
}
