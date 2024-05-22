import engine.board.cell.Cell;
import engine.engine.Engine;
import screen.screen.Screen;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine engine = new Engine();

        Screen screen = new Screen(engine);
        screen.render();
    }
}