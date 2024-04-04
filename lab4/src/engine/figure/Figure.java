package engine.figure;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.player.Player;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


public abstract class Figure implements IFigure {
    @Getter
    @Setter
    private Player player;

    public Boolean checkCellAndAdd(
            ArrayList<Cell> cellArrayList,
            int x,
            int y,
            Board board
    ) {
        Cell cellFromBoard = board.getCellByCoords(x, y);

        if (cellFromBoard.getFigure() == null) {
            cellArrayList.add(
                    Cell.builder()
                            .x(x)
                            .y(y)
                            .build()
            );
            return false;
        }

        if (cellFromBoard.getFigure().player.getSide() == player.getSide()) {
            return true;
        }

        cellArrayList.add(
                Cell.builder()
                        .x(x)
                        .y(y)
                        .build()
        );
        return true;
    }
}
