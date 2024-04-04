package engine.game;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.figure.Figure;
import engine.player.Player;
import engine.player.Side;
import engine.rules.Figures;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    public List<Player> playerList;

    private int moveCounter;

    public Game() {
        this.moveCounter = 0;
        this.playerList = new ArrayList<>();
        this.playerList.add(
                Player.builder()
                        .side(Side.black)
                        .build()
        );
        this.playerList.add(
                Player.builder()
                        .side(Side.white)
                        .build()
        );

        List<Cell> cellList = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                String key = String.valueOf(i) + String.valueOf(j);
                Figure figure = Figures.cellCoordsToFigure.get(key);
                Cell cell = Cell.builder().x(i).y(j).build();
                if (figure != null) {

                    if (j > 4) {
                        figure.setPlayer(this.playerList.get(1));
                    } else {
                        figure.setPlayer(this.playerList.get(0));
                    }

                    cell.setFigure(figure);
                }
                cellList.add(cell);
            }
        }

        this.board = Board.builder()
                .cellList(cellList)
                .build();

    }

    public void makeMove(Cell fromCell, Cell toCell) throws Exception {
        if (fromCell.getFigure() == null) {
            throw new Exception("No figure in this cell");
        }

        List<Cell> allowedMoves = fromCell.getFigure().calculatePossibleMoves(fromCell, this.board);

        System.out.println(allowedMoves);


    }
}
