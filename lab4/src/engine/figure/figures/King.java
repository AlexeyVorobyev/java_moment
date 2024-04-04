package engine.figure.figures;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.figure.Figure;
import engine.utils.Stream;
import lombok.Builder;

import java.util.ArrayList;

@Builder
public class King extends Figure {
    @Override
    public ArrayList<Cell> calculatePossibleMoves(Cell currentCell, Board board) {
        ArrayList<Cell> cellArrayList = new ArrayList<>();

        Stream.streamBottomLeft(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamTopRight(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamTopLeft(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamBottomRight(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamTop(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamLeft(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamRight(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );
        Stream.streamBottom(
                currentCell,
                this,
                cellArrayList,
                board,
                1
        );

        return cellArrayList;
    }

    @Override
    public String toString() {
        return "King";
    }
}
