package org.example;

import java.util.concurrent.*;
import java.time.ZonedDateTime;
public class Main {
    private static  final long  start = System.currentTimeMillis();
    public static final int CARS_COUNT = 4;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(CARS_COUNT);
    public static CyclicBarrier startBarrier = new CyclicBarrier(CARS_COUNT + 1,
            ()-> System.out.println( System.currentTimeMillis() - start + " ms "+ "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
    public static CountDownLatch finishLatch = new CountDownLatch(CARS_COUNT);
    public static int finishCount = 0;


    public static void main(String[] args) {
        System.out.println("0 " + "ms" + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            executorService.execute(car);
        }

        try {
            startBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            ex.printStackTrace();
        }

        try {
            finishLatch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println(System.currentTimeMillis() - start + " ms "  + "ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
            executorService.shutdown();
        }

    }
}
