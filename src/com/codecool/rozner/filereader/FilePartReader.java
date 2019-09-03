package com.codecool.rozner.filereader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        this.filePath = null;
        this.fromLine = 0;
        this.toLine = 0;
    }

    public void setup(String filePath, int fromLine, int toLine) throws IllegalArgumentException {
        this.filePath = filePath;
        if (fromLine < 1) throw new IllegalArgumentException("Starting line must be bigger than 0");
        this.fromLine = fromLine;
        if (toLine < fromLine) throw new IllegalArgumentException("Ending line must be bigger than the starting line");
        this.toLine = toLine;
    }

    public String read() {
        String a = "";
        try {
            FileReader reader = new FileReader(filePath);

            int i;
            while ((i = reader.read()) != -1) {
                a += (char) i;

            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return a;

    }

    public String readLines() {
        String finalTextAsString = "";
        try {
            String text = read();
            String[] splittedText = text.split("\\n+");
            String[] finalText = new String[toLine - fromLine + 1];
            System.arraycopy(splittedText, fromLine - 1, finalText, 0, toLine);
            finalTextAsString = String.join("\n", finalText);

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return finalTextAsString;
    }
}
