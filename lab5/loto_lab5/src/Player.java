import lombok.Getter;

import java.awt.*;
import java.util.Random;

class Player implements Runnable {
    @Getter
    private String name;
    private Color color;
    private Board board;
    @Getter
    private int tilesPlaced;
    private Random random;

    public Player(String name, Color color, Board board) {
        this.name = name;
        this.color = color;
        this.board = board;
        this.tilesPlaced = 0;
        this.random = new Random();
    }

    public boolean isFinished() {
        return tilesPlaced >= board.getSize();
    }

    public void reset() {
        tilesPlaced = 0;
    }

    @Override
    public void run() {
        int tileNumber;
        boolean tilePlaced;
        do {
            tileNumber = random.nextInt(board.getSize()) + 1;
            tilePlaced = board.placeTile(tileNumber, color);
        } while (!tilePlaced);

        tilesPlaced++;
        System.out.println(name + ", фишка " + tileNumber);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}