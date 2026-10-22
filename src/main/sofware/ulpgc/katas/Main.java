package main.sofware.ulpgc.katas;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {

    static void main(String[] args) throws IOException {
        try (InputStream input = Main.class.getResourceAsStream("hello.txt")) {

            if (input == null) {
                throw new FileNotFoundException("No se encuentra hello.txt");
            }
            List<TextLine> lines = TextLineLoader.load(input);
            Summary summary = TextSummary.calculate(lines);
            TextSummaryWriter.write(System.out, summary);

            try (OutputStream output = new FileOutputStream("resultado.txt")) {
                TextSummaryWriter.write(output, summary);
            }
        }


        String text = "!viva España!\n¡viva España!!";

        try (InputStream input = new ByteArrayInputStream(
                text.getBytes(StandardCharsets.UTF_8))) {

            List<TextLine> lines = TextLineLoader.load(input);
            Summary summary = TextSummary.calculate(lines);

            System.out.println("Resumen desde memoria:");
            TextSummaryWriter.write(System.out, summary);
        }
    }
}