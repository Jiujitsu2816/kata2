package main.sofware.ulpgc.katas;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextLineLoader {

    public static List<TextLine> load(InputStream input)
            throws IOException {

        List<TextLine> lines = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(input, StandardCharsets.UTF_8)
        );

        String line;
        int lineNumber = 0;

        while ((line = reader.readLine()) != null) {
            lineNumber++;

            if (line.isBlank()) {
                throw new IOException(
                        "Fila invalida en la linea " + lineNumber
                );
            }

            lines.add(new TextLine(line));
        }

        return lines;
    }
}