package org.example;

import java.time.ZonedDateTime;
import static org.example.Car.start;

public class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(System.currentTimeMillis() - start + " ms " + c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(System.currentTimeMillis() - start + " ms " + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
