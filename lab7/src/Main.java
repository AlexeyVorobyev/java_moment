import classes.Platform;
import classes.Truck;
import classes.Ship;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {

        Truck.delay = 2000;
        Ship.delay = 2000;

        Platform[] platforms = new Platform[5];
        platforms[0] = new Platform();
        platforms[1] = new Platform();
        platforms[2] = new Platform();
        platforms[3] = new Platform();
        platforms[4] = new Platform();

        Truck[] trucks = new Truck[3];
        trucks[0] = new Truck(platforms, "Грузовик 1");
        trucks[1] = new Truck(platforms, "Грузовик 2");
        trucks[2] = new Truck(platforms, "Грузовик 3");

        for (Truck truck : trucks) {
            truck.start();
        }


        Ship[] ships = new Ship[3];
        ships[0] = new Ship(100, "Корабль 1", platforms);
        ships[1] = new Ship(120, "Корабль 2", platforms);
        ships[2] = new Ship(150, "Корабль 3", platforms);


        for (Ship ship : ships) {
            ship.start();
        }

    }
}