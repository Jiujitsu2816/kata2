package sofware.ulpgc.katas;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class GameLoader {

    public static List<Game> load(InputStream input) throws IOException {
        List<Game> games = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8)
        );
        String line = reader.readLine();
        int lineNumber = 1;
        if (line == null) {
            throw new IOException("El fichero esta vacio");
        }
        if (!line.equals("name,genre")) {
            throw new IOException("Cabecera CSV incorrecta");
        }
        while ((line = reader.readLine()) != null) {
            lineNumber++;
            String[] data = line.split(",", -1);
            if (data.length != 2 ||
                    data[0].isBlank() ||
                    data[1].isBlank()) {
                throw new IOException(
                        "Fila invalida en la linea " + lineNumber
                );
            }
            games.add(new Game(data[0].trim(), data[1].trim()));
        }
        return games;
    }
}