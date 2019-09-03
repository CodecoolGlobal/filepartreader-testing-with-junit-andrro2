package com.codecool.rozner.filereader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    FilePartReader reader = new FilePartReader();
    FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);


    @Test
    public void testGetWordsOrderedAlphabeticaly(){
        reader.setup("test/test.txt", 1, 4);
        List<String> listToTest = analyzer.getWordsOrderedAlphabetically();
        List<String> test = Arrays.asList("amaz", "az", "bab", "ez");
        assertEquals(test, listToTest);
    }

    @Test
    public void testGetWordsContainingSubstring(){
        reader.setup("test/test.txt", 1, 4);
        List<String> listToTest = analyzer.getWordsContainingSubstring("ba");
        List<String> test = Arrays.asList("bab");
        assertEquals(test, listToTest);
    }

    @Test
    public void testGetWordsWichArePallindromes(){
        reader.setup("test/test.txt", 1, 4);
        List<String> listToTest = analyzer.getStringsWhichPalindromes();
        List<String> test = Arrays.asList("bab");
        assertEquals(test, listToTest);
    }



}