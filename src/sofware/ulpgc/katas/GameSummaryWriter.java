package sofware.ulpgc.katas;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class GameSummaryWriter {

    public static void write(OutputStream output, Map<String, Integer> summary) throws IOException {
        StringBuilder text = new StringBuilder();
        text.append("Videojuegos por genero:\n");
        Map<String, Integer> sorted = new TreeMap<>(summary);
        for (Map.Entry<String, Integer> entry : sorted.entrySet()) {
            text.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append("\n");
        }
        output.write(text.toString().getBytes(StandardCharsets.UTF_8));
        output.flush();
    }
}