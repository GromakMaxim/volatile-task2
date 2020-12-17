package org.example.shops;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Shop1 {
    private final List<Integer> balance;
    private final int VALUES_LIMIT = 1_000_000;
    private final int LOW_LIMIT = 0;
    private final int UPPER_LIMIT = 100;

    public Shop1() {
        this.balance = new Random().ints(LOW_LIMIT, UPPER_LIMIT)
                .limit(VALUES_LIMIT)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getBalance() {
        return balance;
    }
}
