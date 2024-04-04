package engine.figure;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.player.Player;

import java.util.ArrayList;

public interface IFigure {
    public ArrayList<Cell> calculatePossibleMoves(Cell currentCell, Board board);
    public Player getPlayer();
}
