package sofware.ulpgc.katas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameSummary {

    public static Map<String, Integer> calculate(List<Game> games) {
        Map<String, Integer> summary = new HashMap<>();
        for (Game game : games) {
            String genre = game.genre();
            summary.put(
                    genre,
                    summary.getOrDefault(genre, 0) + 1
            );
        }
        return summary;
    }
}