package com.codecool.rozner.filereader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePartReader ez = new FilePartReader();
        ez.setup("text.txt", 1,6);
        FileWordAnalyzer az = new FileWordAnalyzer(ez);
        az.getWordsOrderedAlphabetically();
        System.out.println(az.getStringsWhichPalindromes());
    }
}
