import lombok.Builder;
import lombok.Setter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Builder
class Board {
    @Setter
    private int sizeX;
    @Setter
    private int sizeY;
    private final List<LotoTile> tiles = new ArrayList<>();


    public int getSize() {
        return sizeX * sizeY;
    }

    public synchronized boolean placeTile(int tileNumber, Color color) {
        for (LotoTile tile : tiles) {
            if (tile.getNumber() == tileNumber && tile.getColor() == null) {
                tile.setColor(color);
                return true;
            }
        }
        return false;
    }

    public synchronized void addTile(LotoTile tile) {
        tiles.add(tile);
    }

    public LotoTile getTile(int index) {
        return tiles.get(index);
    }

    public boolean isFull() {
        for (LotoTile tile : tiles) {
            if (tile.getColor() == null) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (LotoTile tile : tiles) {
            tile.setColor(null);
        }
    }
}