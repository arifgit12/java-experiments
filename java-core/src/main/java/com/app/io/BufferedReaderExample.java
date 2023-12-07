package com.app.io;

import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        ClassLoader classLoader = BufferedReaderExample.class.getClassLoader();
        File newsFile = new File(classLoader.getResource("thewirein.txt").getFile());
        try {
            BufferedReader reader = new BufferedReader(new FileReader(newsFile));
            String line;
            while( (line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
