import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TASK_2_WORD_COUNTER {
    public static void main(String[] args) {
        System.out.println("Enter text or provide a file path to count the words:");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();
        String text = "";
        if (input.startsWith("/") || input.startsWith("C:\\")) {
            try {
                text = new String(Files.readAllBytes(Paths.get(input)));
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                System.exit(1);
            }
        } else {
            text = input;
        }
        String[] words = text.split("[\\s\\p{Punct}]+");
        int wordCount = 0;
        Set<String> stopWords = new HashSet<>();
        stopWords.add("a");
        stopWords.add("an");
        stopWords.add("the");
        stopWords.add("and");
        stopWords.add("or");
        stopWords.add("but");
        stopWords.add("in");
        stopWords.add("on");
        stopWords.add("at");
        stopWords.add("to");
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            if (!stopWords.contains(word.toLowerCase())) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println("Total word count: " + wordCount);
        System.out.println("Number of unique words: " + wordFrequency.size());
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
