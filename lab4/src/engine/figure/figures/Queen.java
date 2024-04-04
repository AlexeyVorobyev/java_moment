package engine.figure.figures;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.figure.Figure;
import engine.utils.Stream;
import lombok.Builder;

import java.util.ArrayList;
import static engine.utils.Stream.unlimitedDistance;

@Builder
public class Queen extends Figure {
    @Override
    public ArrayList<Cell> calculatePossibleMoves(Cell currentCell, Board board) {
        ArrayList<Cell> cellArrayList = new ArrayList<>();

        Stream.streamBottomLeft(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamTopRight(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamTopLeft(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamBottomRight(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamTop(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamLeft(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamRight(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );
        Stream.streamBottom(
                currentCell,
                this,
                cellArrayList,
                board,
                unlimitedDistance
        );

        return cellArrayList;
    }

    @Override
    public String toString() {
        return "Quenn";
    }

}
