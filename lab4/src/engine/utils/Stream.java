package engine.utils;

import engine.figure.Figure;
import engine.rules.Expanse;
import engine.board.cell.Cell;
import engine.board.Board;

import java.util.ArrayList;

public class Stream {
    public static int unlimitedDistance = 1000;
    public static void streamBottomLeft(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX() - 1,
                y = currentCell.getY() - 1,
                counter = 0;
                x >= Expanse.leftBottomCorner.getX() && y >= Expanse.leftBottomCorner.getY() && counter < distance;
                x--, y--, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamBottom(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX(),
                y = currentCell.getY() - 1,
                counter = 0;
                x >= Expanse.leftBottomCorner.getX() && y >= Expanse.leftBottomCorner.getY() && counter < distance;
                y--, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamLeft(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX() - 1,
                y = currentCell.getY(),
                counter = 0;
                x >= Expanse.leftBottomCorner.getX() && y >= Expanse.leftBottomCorner.getY() && counter < distance;
                x--, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamTopRight(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX() + 1,
                y = currentCell.getY() + 1,
                counter = 0;
                x <= Expanse.rightTopCorner.getX() && y <= Expanse.rightBottomCorner.getY() && counter < distance;
                x++, y++, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamTopLeft(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX() - 1,
                y = currentCell.getY() + 1,
                counter = 0;
                x >= Expanse.rightTopCorner.getX() && y <= Expanse.rightBottomCorner.getY() && counter < distance;
                x--, y++, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamTop(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX(),
                y = currentCell.getY() + 1,
                counter = 0;
                x <= Expanse.rightTopCorner.getX() && y <= Expanse.rightBottomCorner.getY() && counter < distance;
                y++, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamRight(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX() + 1,
                y = currentCell.getY(),
                counter = 0;
                x <= Expanse.rightTopCorner.getX() && y <= Expanse.rightBottomCorner.getY() && counter < distance;
                x++, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }

    public static void streamBottomRight(
            Cell currentCell,
            Figure figure,
            ArrayList<Cell> cellArrayList,
            Board board,
            int distance
    ) {
        for (
                int x = currentCell.getX() + 1,
                y = currentCell.getY() - 1,
                counter = 0;
                x <= Expanse.rightBottomCorner.getX() && y >= Expanse.rightBottomCorner.getY() && counter < distance;
                x++, y--, counter++
        ) {
            if (figure.checkCellAndAdd(cellArrayList, x, y, board)) {
                break;
            }
        }
    }
}
