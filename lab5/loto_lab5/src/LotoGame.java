import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LotoGame extends JFrame {
    private final Board board;
    private final List<Player> players;
    private final int boardSizeX = 4;
    private final int boardSizeY = 10;
    private boolean restartPending = false;

    public LotoGame() {
        board = Board.builder()
                .sizeY(boardSizeY)
                .sizeX(boardSizeX).build();
        players = new ArrayList<>();
        players.add(new Player("Розовый", Color.PINK, board, this));
        players.add(new Player("Циан", Color.CYAN, board, this));
        players.add(new Player("Магнета", Color.MAGENTA, board, this));
        players.add(new Player("Желтый", Color.YELLOW, board, this));


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 320);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(boardSizeX, boardSizeY));
        setTitle("Многопоточное Лото?");

        for (int i = 0; i < boardSizeY * boardSizeX; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(50, 50));
            add(button);
            board.addTile(
                    LotoTile.builder()
                            .number(i + 1)
                            .build()
            );

        }

        for (int i = 0; i < 4; i++) {
            int finalI = i;
            new SwingWorker<>() {
                @Override
                protected Void doInBackground() {
                    players.get(finalI).run();
                    return null;
                }
            }.execute();
        }
    }

    void updateBoard() {
        for (int i = 0; i < board.getSize(); i++) {
            LotoTile tile = board.getTile(i);
            JButton button = (JButton) getContentPane().getComponent(i);
            if (tile.getColor() != null) {
                button.setBackground(tile.getColor());
                button.setText(String.valueOf(tile.getNumber()));
                button.setOpaque(true);
                button.setBorderPainted(false);
            }
            else {
                button.setBackground(null);
                button.setText("");
                button.setOpaque(false);
                button.setBorderPainted(true);
            }
        }
        if (this.board.isFull()) {
            this.announceWinner();
        }
    }

    private void announceWinner() {
        int maxTilesPlaced = -1;
        String winner = "";

        for (Player player : players) {
            int tilesPlaced = player.getTilesPlaced();
            if (tilesPlaced > maxTilesPlaced) {
                maxTilesPlaced = tilesPlaced;
                winner = player.getUserName();
            }
        }

        JOptionPane.showMessageDialog(
                this, "Игра окончена! Победил " + winner + " игрок" + " и набрал " + maxTilesPlaced + " очков.",
                "Победитель", JOptionPane.INFORMATION_MESSAGE);
    }
}