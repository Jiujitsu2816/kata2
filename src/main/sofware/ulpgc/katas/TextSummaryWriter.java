package main.sofware.ulpgc.katas;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextSummaryWriter {

    public static void write(OutputStream output, Summary summary)
            throws IOException {

        String text = "Numero de lineas: " + summary.lines() + "\n"
                + "Numero de caracteres: " + summary.characters() + "\n";

        output.write(text.getBytes(StandardCharsets.UTF_8));
        output.flush();
    }
}