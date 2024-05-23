import lombok.Getter;

import java.awt.*;
import java.util.Random;

class Player extends Thread {
    @Getter
    private String userName;
    private Color color;
    private Board board;
    @Getter
    private int tilesPlaced;
    private LotoGame game;
    private Random random;

    public Player(String name, Color color, Board board, LotoGame game) {
        this.userName = name;
        this.color = color;
        this.board = board;
        this.tilesPlaced = 0;
        this.game = game;
        this.random = new Random();
    }

    public void reset() {
        tilesPlaced = 0;
    }

    public void run() {
        super.run();
        int tileNumber;
        boolean tilePlaced;
        while(true) {
            do {
                tileNumber = random.nextInt(board.getSize()) + 1;
                tilePlaced = board.placeTile(tileNumber, color);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } while (!tilePlaced);

            tilesPlaced++;
            game.updateBoard();
            System.out.println(userName + ", фишка " + tileNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}