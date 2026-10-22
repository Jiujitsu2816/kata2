package main.sofware.ulpgc.katas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class GameLoader {
    private GameLoader() { }

    public static List<Game> load(InputStream input) throws IOException {
        if (input == null) throw new IOException("El origen de datos no existe");
        List<Game> games = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        String line;
        int number = 0;
        while ((line = reader.readLine()) != null) {
            number++;
            if (number == 1 && line.equals("title,genre,year")) continue;
            if (line.isBlank()) throw new IOException("Fila vacia en la linea " + number);
            String[] fields = line.split(",", -1);
            if (fields.length != 3 || fields[0].isBlank() || fields[1].isBlank())
                throw new IOException("Fila invalida en la linea " + number + ": " + line);
            try {
                int year = Integer.parseInt(fields[2].trim());
                if (year < 1950 || year > 2100) throw new NumberFormatException();
                games.add(new Game(fields[0].trim(), fields[1].trim(), year));
            } catch (NumberFormatException e) {
                throw new IOException("Anio invalido en la linea " + number + ": " + fields[2], e);
            }
        }
        return games;
    }
}
