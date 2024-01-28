package com.app.intellij;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class JetBrainsRegistryCleanUp {

    private static final String APPDATA = System.getenv("APPDATA");
    private static final String JB_DATA_FOLDER = APPDATA + "\\JetBrains";

    private static final String[] PRODUCTS = {"WebStorm", "DataGrip", "CLion", "Rider", "GoLand", "PhpStorm", "Resharper", "PyCharm"};

    public static void main(String[] args) {
        for (String product : PRODUCTS) {
            cleanup(product);
        }

        // Delete registry key (not sure if needed in Java, as Java does not directly manipulate the registry)
        // reg delete "HKEY_CURRENT_USER\Software\JavaSoft" /f;

        System.out.println("done");
    }

    private static void cleanup(String product) {
        String productPattern = product + ".*";
        File[] productFolders = findMatchingFolders(new File(JB_DATA_FOLDER), productPattern);

        for (File productFolder : productFolders) {
            removeEval(productFolder);
            updateOtherXml(productFolder);
        }
    }

    private static File[] findMatchingFolders(File parentFolder, String pattern) {
        File[] matchingFolders = parentFolder.listFiles((dir, name) -> name.matches(pattern));
        return matchingFolders != null ? matchingFolders : new File[0];
    }

    private static void removeEval(File productFolder) {
        File evalFolder = new File(productFolder, "eval");
        deleteFolder(evalFolder);
    }

    private static void updateOtherXml(File productFolder) {
        File optionsFolder = new File(productFolder, "options");
        File otherXml = new File(optionsFolder, "other.xml");
        File otherXmlBackup = new File(optionsFolder, "other_backup.xml");

        try {
            // Backup other.xml
            Files.copy(otherXml.toPath(), otherXmlBackup.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Read other.xml, remove lines containing "evlsprt", and write back
            Files.lines(otherXml.toPath())
                    .filter(line -> !line.toLowerCase().contains("evlsprt"))
                    .forEach(line -> {
                        // Write modified content to other.xml
                        try {
                            Files.write(otherXml.toPath(), (line + System.lineSeparator()).getBytes(),
                                    StandardOpenOption.APPEND);
                        } catch (IOException exception) {
                            exception.printStackTrace();
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteFolder(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFolder(file);
                } else {
                    file.delete();
                }
            }
        }
        folder.delete();
    }
}
