package engine.figure.figures;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.figure.Figure;
import engine.player.Side;
import engine.rules.Expanse;
import lombok.Builder;

import java.util.ArrayList;

@Builder
public class Pawn extends Figure {

    @Override
    public ArrayList<Cell> calculatePossibleMoves(Cell currentCell, Board board) {
        ArrayList<Cell> cellArrayList = new ArrayList<>();

        if (
                currentCell.getX() - 1 >= Expanse.leftTopCorner.getX()
        ) {
            Cell nextCell = board.getCellByCoords(
                    currentCell.getX() - 1,
                    currentCell.getY()
            );
            if (nextCell.getFigure() != null) {
                cellArrayList.add(nextCell);
            }
        }

        if (currentCell.getX() + 1 <= Expanse.rightTopCorner.getX()) {
            Cell nextCell = board.getCellByCoords(
                    currentCell.getX() + 1,
                    currentCell.getY()
            );
            if (nextCell.getFigure() != null) {
                cellArrayList.add(nextCell);
            }
        }

        if (this.getPlayer().getSide() == Side.white) {
            if (currentCell.getY() + 1 > Expanse.rightTopCorner.getY()) {
                return cellArrayList;
            }

            Cell forwardCell = board.getCellByCoords(
                    currentCell.getX(),
                    currentCell.getY() + 1
            );

            if (forwardCell.getFigure() == null) {
                cellArrayList.add(forwardCell);
            }
        }
        else {
            if (currentCell.getY() - 1 > Expanse.leftBottomCorner.getY()) {
                return cellArrayList;
            }

            Cell forwardCell = board.getCellByCoords(
                    currentCell.getX(),
                    currentCell.getY() - 1
            );

            if (forwardCell.getFigure() == null) {
                cellArrayList.add(forwardCell);
            }
        }

        return cellArrayList;
    }
}
