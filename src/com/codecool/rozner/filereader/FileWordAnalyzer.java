package com.codecool.rozner.filereader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically (){
        String text = filePartReader.readLines();
        List<String> orderedText;
        orderedText = Arrays.asList(text.split("\\s+"));
        Collections.sort(orderedText);
        return orderedText;

    }

    public List getWordsContainingSubstring (String subString ){
        String text = filePartReader.readLines();
        List<String> words = Arrays.asList(text.split("\\s+"));
        List<String> wordsContainSubstring = new ArrayList<>();
        for(String word : words){
            if(word.contains(subString))
            {
                wordsContainSubstring.add(word);
            }
        }
        return wordsContainSubstring;
    }

    public List<String> getStringsWhichPalindromes (){
        String text = filePartReader.readLines();
        List<String> words = Arrays.asList(text.split("\\s+"));
        List<String> palindromes = new ArrayList<>();
        for(String word :words){
            String reverse = new StringBuffer(word).reverse().toString();
            if(reverse.equalsIgnoreCase(word))
                palindromes.add(word);

        }
        return palindromes;
    }
}
