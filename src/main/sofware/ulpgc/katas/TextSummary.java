package main.sofware.ulpgc.katas;

import java.util.List;

public class TextSummary {

    public static Summary calculate(List<TextLine> lines) {
        int characters = 0;

        for (TextLine line : lines) {
            characters += line.content().length();
        }

        return new Summary(lines.size(), characters);
    }
}