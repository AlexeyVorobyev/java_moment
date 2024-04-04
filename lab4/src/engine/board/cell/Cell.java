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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Cell other = (Cell) obj;

        return other.x == this.x
                && other.y == this.y;
    }
}
