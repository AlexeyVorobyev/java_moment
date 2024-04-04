import engine.board.cell.Cell;
import engine.engine.Engine;
import screen.screen.Screen;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine();

        Screen screen = new Screen(engine);
        screen.reRender();
        Thread.sleep(2000);

        engine.makeMove(
                Cell.builder()
                        .x(2)
                        .y(1)
                        .build(),
                Cell.builder()
                        .x(3)
                        .y(3)
                        .build()
        );

        screen.reRender();
        Thread.sleep(2000);

        engine.makeMove(
                Cell.builder()
                        .x(4)
                        .y(7)
                        .build(),
                Cell.builder()
                        .x(4)
                        .y(5)
                        .build()
        );

        screen.reRender();
        Thread.sleep(2000);

        engine.makeMove(
                Cell.builder()
                        .x(4)
                        .y(2)
                        .build(),
                Cell.builder()
                        .x(4)
                        .y(4)
                        .build()
        );

        screen.reRender();
        Thread.sleep(2000);
    }
}