package main.sofware.ulpgc.katas;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Origen 1: recurso del proyecto
            try (InputStream input = Main.class.getResourceAsStream("games.csv")) {
                List<Game> games = GameLoader.load(input);
                Map<String, Integer> summary = GameSummary.countByGenre(games);
                // Destino 1: consola
                SummaryWriter.write(System.out, summary);
                // Destino 2: fichero
                try (OutputStream output = new FileOutputStream("resultado.txt")) {
                    SummaryWriter.write(output, summary);
                }
            }

            // Origen 2: memoria; misma logica, sin cambios
            String csv = "title,genre,year\nMinecraft,Sandbox,2011\nCivilization VI,Strategy,2016\n";
            try (InputStream input = new ByteArrayInputStream(csv.getBytes(StandardCharsets.UTF_8))) {
                Map<String, Integer> summary = GameSummary.countByGenre(GameLoader.load(input));
                System.out.println("Resumen desde memoria:");
                SummaryWriter.write(System.out, summary);
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
