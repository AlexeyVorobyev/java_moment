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

            if (
                    currentCell.getX() - 1 >= Expanse.leftTopCorner.getX()
            ) {
                Cell nextCell = board.getCellByCoords(
                        currentCell.getX() - 1,
                        currentCell.getY() + 1
                );
                if (nextCell.getFigure() != null) {
                    cellArrayList.add(nextCell);
                }
            }

            if (currentCell.getX() + 1 <= Expanse.rightTopCorner.getX()) {
                Cell nextCell = board.getCellByCoords(
                        currentCell.getX() + 1,
                        currentCell.getY() + 1
                );
                if (nextCell.getFigure() != null) {
                    cellArrayList.add(nextCell);
                }
            }

            if (!this.moved) {
                if (currentCell.getY() + 2 > Expanse.rightTopCorner.getY()) {
                    return cellArrayList;
                }

                Cell forwardCell2 = board.getCellByCoords(
                        currentCell.getX(),
                        currentCell.getY() + 2
                );

                if (forwardCell2.getFigure() == null) {
                    cellArrayList.add(forwardCell2);
                }
            }
        }
        else {
            if (currentCell.getY() - 1 < Expanse.leftBottomCorner.getY()) {
                return cellArrayList;
            }

            Cell forwardCell = board.getCellByCoords(
                    currentCell.getX(),
                    currentCell.getY() - 1
            );

            if (forwardCell.getFigure() == null) {
                cellArrayList.add(forwardCell);
            }

            if (
                    currentCell.getX() - 1 >= Expanse.leftTopCorner.getX()
            ) {
                Cell nextCell = board.getCellByCoords(
                        currentCell.getX() - 1,
                        currentCell.getY() - 1
                );
                if (nextCell.getFigure() != null) {
                    cellArrayList.add(nextCell);
                }
            }

            if (currentCell.getX() + 1 <= Expanse.rightTopCorner.getX()) {
                Cell nextCell = board.getCellByCoords(
                        currentCell.getX() + 1,
                        currentCell.getY() - 1
                );
                if (nextCell.getFigure() != null) {
                    cellArrayList.add(nextCell);
                }
            }

            if (!this.moved) {
                if (currentCell.getY() - 2 < Expanse.leftBottomCorner.getY()) {
                    return cellArrayList;
                }

                Cell forwardCell2 = board.getCellByCoords(
                        currentCell.getX(),
                        currentCell.getY() - 2
                );

                if (forwardCell2.getFigure() == null) {
                    cellArrayList.add(forwardCell2);
                }
            }
        }

        return cellArrayList;
    }

    @Override
    public String toString() {
        return "Pawn";
    }
}
