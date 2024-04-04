package engine.engine;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.figure.Figure;
import engine.player.Player;
import engine.player.Side;
import engine.rules.Figures;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Engine {
    @Getter
    private Board board;
    public List<Player> playerList;

    private int moveCounter;

    public Engine() {
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
                        figure.setPlayer(this.playerList.get(0));
                    } else {
                        figure.setPlayer(this.playerList.get(1));
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
        Cell boardFromCell = this.board.getCellByCoords(fromCell.getX(), fromCell.getY());

        if (boardFromCell.getFigure() == null) {
            throw new Exception("No figure in this cell");
        }

        if (moveCounter % 2 == 0) {
            if (boardFromCell.getFigure().getPlayer().getSide() == Side.black) {
                throw new Exception("Move not allowed, wrong side");
            }
        } else {
            if (boardFromCell.getFigure().getPlayer().getSide() == Side.white) {
                throw new Exception("Move not allowed, wrong side");
            }
        }

        System.out.println(boardFromCell.getFigure());
        System.out.println(boardFromCell.getFigure().getPlayer().getSide());

        List<Cell> allowedMoves = boardFromCell.getFigure().calculatePossibleMoves(fromCell, this.board);

        allowedMoves.forEach((item) -> {
            System.out.printf("X:%d Y:%d Figure:%s\n",item.getX(), item.getY(), item.getFigure());
        });

        if (allowedMoves.contains(toCell)) {
            System.out.println("Move allowed");
        }
        else {
            throw new Exception("Move not allowed");
        }

        Cell boardToCell = this.board.getCellByCoords(toCell.getX(), toCell.getY());

        System.out.printf(
                "Move X:%d Y:%d Figure:%s \n-> X:%d Y:%d Figure:%s\n",
                boardFromCell.getX(),
                boardFromCell.getY(),
                boardFromCell.getFigure(),
                boardToCell.getX(),
                boardToCell.getY(),
                boardToCell.getFigure()
        );

        boardToCell.setFigure(boardFromCell.getFigure());
        boardFromCell.setFigure(null);
        this.moveCounter++;
    }
}
