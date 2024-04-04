package engine.rules;

import engine.board.cell.Cell;

public class Expanse {
    public static Cell leftBottomCorner = Cell
            .builder()
            .x(1)
            .y(1)
            .build();

    public static Cell rightBottomCorner = Cell
            .builder()
            .x(1)
            .y(8)
            .build();

    public static Cell leftTopCorner = Cell
            .builder()
            .x(8)
            .y(1)
            .build();

    public static Cell rightTopCorner = Cell
            .builder()
            .x(8)
            .y(8)
            .build();
}
