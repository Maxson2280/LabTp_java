package org.example;

import java.time.ZonedDateTime;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + c.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
