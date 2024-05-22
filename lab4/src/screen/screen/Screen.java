package screen.screen;

import engine.board.Board;
import engine.board.cell.Cell;
import engine.engine.Engine;
import engine.player.Side;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Screen extends JFrame {

    //intialize variables
    private Image boardImage1;
    private Image boardImage2;
    //intialize components
    private JPanel centerPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    private JPanel inputPanel = new JPanel();
    private JPanel westPanel = new JPanel();
    //initialze arrays to hold panels and images of the board
    private JLabel[] labels = new JLabel[64];
    private ImagePanel[] panels = new ImagePanel[64];

    @Getter
    @Setter
    private Engine engine;

    public Screen(Engine engine) throws IOException {
        this.boardImage1 = ImageIO.read(new File("src/screen/image/block/blackBlock.png"));

        this.boardImage2 = ImageIO.read(new File("src/screen/image/block/whiteBlock.png"));
        this.engine = engine;
        createAndShowGUI();//call method to create gui
        this.addInputToInputPanel(engine);
        this.render();
    }

    private void createAndShowGUI() {
        setTitle("Chess board example");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        addComponentsToPane(getContentPane());

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Adds all the necessary components to the content pane of the JFrame, and
     * adds appropriate listeners to components.
     */
    private void addComponentsToPane(Container contentPane) {

        GridLayout gridLayout = new GridLayout(8, 8);
        centerPanel.setLayout(gridLayout);

        //call mehod to add labels to south panel
        addLabelsToSouthPanel();
        //call method to add oanels to west panel
        addLabelsToWestPanel();
        //call method to add panels and labels to the center panel which holds the board
        addPanelsAndLabels();
        //add all panels to frame

        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        contentPane.add(inputPanel, BorderLayout.EAST);
        contentPane.add(westPanel, BorderLayout.WEST);
    }

    public static JButton inputButton = new JButton("Send");
    public static JTextArea editTextAreaFrom = new JTextArea("12");
    public static JTextArea editTextAreaTo = new JTextArea("14");


    private void addInputToInputPanel(Engine engine) {
        editTextAreaFrom.setMaximumSize(new Dimension(60,50));
        editTextAreaFrom.setMinimumSize(new Dimension(60,50));
        editTextAreaTo.setMaximumSize(new Dimension(60,50));
        editTextAreaTo.setMinimumSize(new Dimension(60,50));
        inputPanel.add(editTextAreaFrom);
        inputPanel.add(editTextAreaTo);
        inputPanel.add(inputButton);

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // MA - Using the class field myString to receive text from text area

                String fromString = editTextAreaFrom.getText();
                String toString = editTextAreaTo.getText();

                System.out.println(fromString);
                System.out.println(toString);

                System.out.println(fromString.charAt(0));
                System.out.println(toString);

                try {
                    engine.makeMove(
                            Cell.builder()
                                    .x(fromString.charAt(0)  - '0')
                                    .y(fromString.charAt(1)  - '0')
                                    .build(),
                            Cell.builder()
                                    .x(toString.charAt(0)  - '0')
                                    .y(toString.charAt(1)  - '0')
                                    .build()
                    );
                    render();
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                }


//                editTextAreaFrom.setText("");
//                editTextAreaTo.setText("");
            }
        });
    }

    private void addLabelsToSouthPanel() {
        GridLayout gridLayout = new GridLayout(0, 8);

        southPanel.setLayout(gridLayout);
        JLabel[] lbls = new JLabel[8];
        String[] label = {"A", "B", "C", "D", "E", "F", "G", "H"};

        for (int i = 0; i < 8; i++) {
            lbls[i] = new JLabel(label[i] + "");
            southPanel.add(lbls[i]);
        }
    }

    private void addLabelsToWestPanel() {
        GridLayout gridLayout = new GridLayout(8, 0);

        westPanel.setLayout(gridLayout);
        JLabel[] lbls = new JLabel[8];
        int[] num = {8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < 8; i++) {
            lbls[i] = new JLabel(num[i] + "");
            westPanel.add(lbls[i]);
        }
    }


    private void addPanelsAndLabels() {

        //call methd to create panels with backgound images and appropriate names
        addPanelsAndImages();

        for (int i = 0; i < panels.length; i++) {
            labels[i] = new JLabel();

            //used to know the postion of the label on the board
            labels[i].setName(panels[i].getName());

            panels[i].add(labels[i]);

            //adds panels created in addPanelsAndImages()
            centerPanel.add(panels[i]);
        }
    }

    //this method will create panels with backround images of chess board and set its name according to 1-8 for rows and A-H for coloumns
    private void addPanelsAndImages() {
        int count = 0;
        String[] label = {"A", "B", "C", "D", "E", "F", "G", "H"};
        int[] num = {8, 7, 6, 5, 4, 3, 2, 1};

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((col + row) % 2 == 0) {//even numbers get white pieces
                    panels[count] = new ImagePanel(boardImage1);
                } else {//odd numbers get black pieces
                    panels[count] = new ImagePanel(boardImage2);
                }

                panels[count].setName(label[col] + num[row]);
                count++;
            }
        }
    }

    //method sets image of a label at a certain position in the board according to the block name i.e D4
    private void addPiece(String text, String block, Color color) {
        for (int s = 0; s < labels.length; s++) {
            if (labels[s].getName().equalsIgnoreCase(block)) {
                labels[s].setText(text);
                labels[s].setForeground(color);
            }
        }
    }

    private void clearPieces() {
        for (int s = 0; s < labels.length; s++) {
            labels[s].setText("");
        }
    }

    private void setPieces() {
        Board board = this.engine.getBoard();

        String[] label = {"A", "B", "C", "D", "E", "F", "G", "H"};
        int[] num = {8, 7, 6, 5, 4, 3, 2, 1};

        board.getCellList().forEach((item) -> {
            if (item.getFigure() == null) {
                return;
            }

            if (item.getFigure().getPlayer().getSide() == Side.black) {
                this.addPiece(
                        item.getFigure().toString(),
                        label[item.getX() - 1] + num[8 - item.getY()],
                        Color.BLUE
                );
            } else {
                this.addPiece(
                        item.getFigure().toString(),
                        label[item.getX() - 1] + num[8 - item.getY()],
                        Color.RED
                );
            }
        });
    }

    public void render() {
        this.clearPieces();
        this.setPieces();
    }

    //nested class used to set the background of frame contenPane
    class ImagePanel extends JPanel {

        private Image image;

        /**
         * Default constructor used to set the image for the background for the
         * instance
         */
        public ImagePanel(Image img) {
            image = img;
        }

        @Override
        protected void paintComponent(Graphics g) {
            //draws image to background to scale of frame
            g.drawImage(image, 0, 0, null);
        }
    }
}