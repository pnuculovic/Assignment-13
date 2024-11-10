import java.io.*;
import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        // Map to store words and their counts
        Map<String, Integer> wordCounts = new HashMap<>();

        // Reading the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String word;
            while ((word = reader.readLine()) != null) {
                // Convert word to lowercase to make it case-insensitive
                word = word.toLowerCase();
                // Update the count of the word in the map
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        } catch (IOException e) {
            System.out.println("Error reading the input file: " + e.getMessage());
        }

        // Writing the word counts to the output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the output file: " + e.getMessage());
        }

        System.out.println("Word counting completed. Results are saved in " + outputFilePath);
    }
}
