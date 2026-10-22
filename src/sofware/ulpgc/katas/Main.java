package sofware.ulpgc.katas;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class Main {

static void main() throws IOException {
        try (InputStream input = Main.class.getResourceAsStream("/resources/games.csv")) {
            if (input == null) {
                throw new FileNotFoundException("No se encuentra games.csv");
            }
            List<Game> games = GameLoader.load(input);
            Map<String, Integer> summary = GameSummary.calculate(games);
            System.out.println("=== DATOS DESDE FICHERO ===");
            GameSummaryWriter.write(System.out, summary);
            try (OutputStream output = new FileOutputStream("resultado.txt")) {
                GameSummaryWriter.write(output, summary);
            }
        }

        String data = """
                name,genre
                Minecraft,Sandbox
                Civilization VI,Strategy
                Stellaris,Strategy
                The Sims 4,Simulation
                """;

        try (InputStream input = new ByteArrayInputStream(
                data.getBytes(StandardCharsets.UTF_8))) {
            List<Game> games = GameLoader.load(input);
            Map<String, Integer> summary = GameSummary.calculate(games);
            System.out.println("\n=== DATOS DESDE MEMORIA ===");
            GameSummaryWriter.write(System.out, summary);
        }
    }
}