package main.sofware.ulpgc.katas;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class SummaryWriter {
    private SummaryWriter() { }

    public static void write(OutputStream output, Map<String, Integer> summary) throws IOException {
        StringBuilder text = new StringBuilder("Videojuegos por genero:\n");
        for (Map.Entry<String, Integer> entry : summary.entrySet()) {
            text.append(entry.getKey()).append(": ").append(entry.getValue()).append('\n');
        }
        output.write(text.toString().getBytes(StandardCharsets.UTF_8));
        output.flush();
    }
}
