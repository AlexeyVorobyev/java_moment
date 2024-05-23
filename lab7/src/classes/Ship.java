package classes;

public class Ship extends Thread {
    private int tonnage;
    private int currentTonnage;
    private final Platform[] platforms;
    private String name;
    static public int delay = 2000;


    public Ship(int tonnage, String name, Platform[] platforms) {
        this.platforms = platforms;
        this.tonnage = tonnage;
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
                if (platforms[index].sutedByShip) {
                    continue;
                }
            }
            while (this.currentTonnage < this.tonnage) {
                synchronized (platforms[index]) {
                    platforms[index].sutedByShip = true;
                    if (platforms[index].currentLoad == 0) {
                        try {
                            Thread.sleep(delay);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        if (platforms[index].currentLoad - (tonnage - currentTonnage) > 0) {
                            platforms[index].currentLoad -= tonnage - currentTonnage;
                            currentTonnage += tonnage - currentTonnage;
                        } else {
                            currentTonnage += platforms[index].currentLoad;
                            platforms[index].currentLoad = 0;
                        }
                        System.out.println("Тоннаж коробля " + this.name + ": " + this.currentTonnage);
                    }
                }
            }
            synchronized (platforms[index]) {
                platforms[index].sutedByShip = false;
                System.out.println("Корабль " + this.name + " загружен");
                this.currentTonnage = 0;
            }
        }
    }
}