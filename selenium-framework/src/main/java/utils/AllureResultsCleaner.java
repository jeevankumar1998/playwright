package utils;

import java.io.File;

public class AllureResultsCleaner {

    public static void clearAllureResultsFolder() {
        //  allure-results folder
        File resultsFolder = new File("allure-results");

        if (resultsFolder.exists() && resultsFolder.isDirectory()) {
            deleteFolder(resultsFolder);
            System.out.println("🔥 Cleared the allure-results folder.");
        } else {
            System.out.println("⚠️ allure-results folder not found. Skipping deletion.");
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
    public static void main(String[] args) {
        clearAllureResultsFolder();
    }

}
