package engine.board.cell;

import engine.figure.Figure;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class Cell {
    private int x;
    private int y;
    private Figure figure;

    @ov
}
