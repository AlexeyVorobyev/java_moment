package classes;

import java.util.Random;
import java.util.concurrent.CompletableFuture;


public class Truck extends Thread {
    private int capacity;
    private Platform[] platforms;
    static public int delay = 500;
    private String name;

    public Truck(Platform[] platforms, String name) {
        this.platforms = platforms;
        this.capacity = 10;
        this.name = name;
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            int index = getRandomNumber(0, platforms.length);
            synchronized (platforms[index]) {
                if (platforms[index].sutedByTruck) {
                    continue;
                }
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (platforms[index]) {
                platforms[index].sutedByTruck = true;
                platforms[index].currentLoad += this.capacity;
                System.out.println("Грузовик " + this.name + " отгрузил " + this.capacity + " на платформу " + (index + 1));
                System.out.println("На платформе " + (index + 1) + " уже " + this.platforms[index].currentLoad + " тонн");
                platforms[index].sutedByTruck = false;
            }
        }
    }
}


