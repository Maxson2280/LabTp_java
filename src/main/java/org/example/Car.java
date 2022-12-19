package org.example;

import java.time.ZonedDateTime;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + this.name + " готов");
            Main.startBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        Main.finishLatch.countDown();
        int finishPlace = Main.finishCount++;
        if (finishPlace == 1) {
            System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + this.name + " WIN");
        }
    }
}
