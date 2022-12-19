package org.example;

import java.time.ZonedDateTime;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    Semaphore smp =  new Semaphore(Main.CARS_COUNT/2) ;
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(ZonedDateTime.now().toInstant().toEpochMilli() + " ms " + c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
