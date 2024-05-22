import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Builder
class LotoTile {
    @Getter
    @Setter
    private int number;
    @Getter
    @Setter
    private Color color = null;
}