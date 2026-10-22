package main.sofware.ulpgc.katas;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class GameSummary {
    private GameSummary() { }

    public static Map<String, Integer> countByGenre(List<Game> games) {
        Map<String, Integer> counts = new TreeMap<>();
        for (Game game : games) counts.merge(game.genre(), 1, Integer::sum);
        return counts;
    }
}
