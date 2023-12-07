package com.app.file;

import java.io.File;
import java.io.FilenameFilter;

public class DirectoryExample {

    public static void main(String[] args) {

        FilenameFilter filter = (file, fileName) -> {
            return fileName.contains(".iml");
        };

        String[] contents = new File(".").list(filter);
        for(String file: contents) {
            System.out.println(file);
        }
    }

}
