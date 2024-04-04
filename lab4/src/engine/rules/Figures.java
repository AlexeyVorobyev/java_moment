package engine.rules;

import engine.figure.Figure;
import engine.figure.figures.*;

import java.util.HashMap;
import java.util.Map;

public class Figures {
    public static Map<String, Figure> cellCoordsToFigure = new HashMap<String, Figure>() {{
        put("12", Pawn.builder().build());
        put("22", Pawn.builder().build());
        put("32", Pawn.builder().build());
        put("42", Pawn.builder().build());
        put("52", Pawn.builder().build());
        put("62", Pawn.builder().build());
        put("72", Pawn.builder().build());
        put("82", Pawn.builder().build());

        put("17", Pawn.builder().build());
        put("27", Pawn.builder().build());
        put("37", Pawn.builder().build());
        put("47", Pawn.builder().build());
        put("57", Pawn.builder().build());
        put("67", Pawn.builder().build());
        put("77", Pawn.builder().build());
        put("87", Pawn.builder().build());

        put("11", Rook.builder().build());
        put("21", Knight.builder().build());
        put("31", Bishop.builder().build());
        put("41", King.builder().build());
        put("51", Queen.builder().build());
        put("61", Bishop.builder().build());
        put("71", Knight.builder().build());
        put("81", Rook.builder().build());

        put("18", Rook.builder().build());
        put("28", Knight.builder().build());
        put("38", Bishop.builder().build());
        put("48", Queen.builder().build());
        put("58", King.builder().build());
        put("68", Bishop.builder().build());
        put("78", Knight.builder().build());
        put("88", Rook.builder().build());
    }};
}
