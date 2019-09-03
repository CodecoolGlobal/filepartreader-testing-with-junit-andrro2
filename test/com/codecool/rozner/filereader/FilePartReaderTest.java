package com.codecool.rozner.filereader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader filePartReader = new FilePartReader();

    @Test
    public void testIsFromlineLessThanOne(){
        assertThrows(IllegalArgumentException.class, ()->{filePartReader.setup("test.txt", -1,5);});
    }

    @Test
    public void testIsTolineLessThanFromline(){
        assertThrows(IllegalArgumentException.class,  ()->{filePartReader.setup("test.txt", 2,1);});
    }

    @Test
    public void testReadFileFromTo(){
        filePartReader.setup("test/test.txt",1,3);
        String text = filePartReader.readLines();
        assertEquals("az\nez\namaz", text);
    }

    @Test
    public void testReaderCanReadFile(){
        filePartReader.setup("test/test.txt",1,1);
        String fullText = filePartReader.read();
        assertNotNull(fullText);
    }

    @Test
    public void testReadFirstLine() {
        filePartReader.setup("test/test.txt", 1, 1);
        String text = filePartReader.readLines();
        assertEquals("az", text);
    }


}