package org.example;

import org.example.shops.Shop1;
import org.example.shops.Shop2;
import org.example.shops.Shop3;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Shop1 sh1 = new Shop1();
        Shop2 sh2 = new Shop2();
        Shop3 sh3 = new Shop3();

        ThreadCalculator calculator = new ThreadCalculator(sh1, sh2, sh3);

        System.out.println("Сумма по всем магазинам: " + calculator.getMoney().get());
    }
}
