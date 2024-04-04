package engine.board;

import engine.board.cell.Cell;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
public class Board {
    @Getter
    @Setter
    private List<Cell> cellList;

    public Cell getCellByCoords(int x, int y) {
        return cellList.stream()
                .filter((item) -> item.getX() == x && item.getY() == y)
                .findFirst()
                .get();
    }
}
