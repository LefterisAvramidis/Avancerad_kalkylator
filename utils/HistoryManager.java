package utils;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class HistoryManager {
    private static final String HISTORY_FILE = "history.txt";

    public static void save(String entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Kunde inte spara historik: " + e.getMessage());
        }
    }

    public static String loadHistory() {
        try {
            List<String> lines = Files.readAllLines(Paths.get(HISTORY_FILE));
            return String.join("\n", lines);
        } catch (IOException e) {
            return "";
        }
    }

    public static void clearHistory() {
        try {
            Files.deleteIfExists(Paths.get(HISTORY_FILE));
            Files.createFile(Paths.get(HISTORY_FILE));
        } catch (IOException e) {
            System.err.println("Kunde inte rensa historik: " + e.getMessage());
        }
    }
}
