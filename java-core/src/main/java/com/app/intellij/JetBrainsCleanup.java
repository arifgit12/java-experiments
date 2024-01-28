package com.app.intellij;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JetBrainsCleanup {

    private static final String USER_PROFILE = System.getenv("USERPROFILE");
    private static final String APPDATA = System.getenv("APPDATA");
    private static final String JB_DATA_FOLDER = APPDATA + "\\JetBrains";

    private static final Pattern PATTERN = Pattern.compile("\\.?(IntelliJIdea|GoLand|CLion|PyCharm|DataGrip|RubyMine|AppCode|PhpStorm|WebStorm|Rider).*", Pattern.CASE_INSENSITIVE);


    public static void main(String[] args) {
        cleanup(USER_PROFILE);
        cleanup(JB_DATA_FOLDER);

        System.out.println("done");
    }

    private static void cleanup(String folderPath) {
        File homeFolder = new File(folderPath);

        if (homeFolder.exists() && homeFolder.isDirectory()) {
            for (File subFolder : homeFolder.listFiles()) {
                removeEval(subFolder, folderPath + "\\" + subFolder.getName() + "\\config\\eval");
            }
        }
    }

    private static void removeEval(File folder, String evalPath) {
        Matcher matcher = PATTERN.matcher(folder.getName());

        if (!matcher.find()) {
            return;
        }

        File evalFolder = new File(evalPath);
        if (evalFolder.exists() && evalFolder.isDirectory()) {
            System.out.println(evalPath);
            //deleteFolder(evalFolder);
        }
    }

//    private static void deleteFolder(File folder) {
//        File[] files = folder.listFiles();
//        if (files != null) {
//            for (File file : files) {
//                if (file.isDirectory()) {
//                    deleteFolder(file);
//                } else {
//                    file.delete();
//                }
//            }
//        }
//        folder.delete();
//    }
}
