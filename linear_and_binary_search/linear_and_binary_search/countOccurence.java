//Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears in the file.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class countOccurence {
    public static void main(String[] args) {

        // Specify the path to the file you want to read
        String filePath = "C:\\Users\\Himanshi\\Documents\\example.txt";


     // The word to count occurrences of
        String targetWord = "you";
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                String[] words = line.split(" ");

                for (String word : words) {
                    if (word.equals(targetWord)) {
                        wordCount++;
                    }
                }
            }

            System.out.println("The word '" + targetWord + "' appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
