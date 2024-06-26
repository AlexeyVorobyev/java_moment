package engine.figure.figures;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.figure.Figure;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;

@Builder
public class Knight extends Figure {
    private final int[][] matrix = {
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1},
            {1, 2},
            {-1, 2},
            {1, -2},
            {-1, -2},
    };

    @Override
    public ArrayList<Cell> calculatePossibleMoves(Cell currentCell, Board board) {
        ArrayList<Cell> cellArrayList = new ArrayList<>();

        Arrays.stream(matrix).forEach((item) -> {
            try {
                Cell nextCell = board.getCellByCoords(
                        currentCell.getX() + item[0],
                        currentCell.getY() + item[1]
                );

                super.checkCellAndAdd(cellArrayList,nextCell.getX(),nextCell.getY(), board);
            } catch (Exception e) {
                System.out.println(e);
            }
        });


        return cellArrayList;
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
