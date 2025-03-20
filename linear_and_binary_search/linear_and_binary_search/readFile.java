//Write a program that uses FileReader to read a text file line by line and print each line to the console.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
    
    public class readFile {

        public static void main(String[] args) {

            // add the path of the file you want to read
            String filePath = "C:\\Users\\Himanshi\\Documents\\example.txt"; 
    
            
             //* BufferedReader is used here to read text from the file efficiently.
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;

                // readLine() reads line of a text and return it as a string
                // Read lines one by one until the end of the file is reached
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); 
                }
            } catch (IOException e) {
                //  Catches any IOException, such as file not found or read errors
                System.err.println("Error reading file: " + e.getMessage()); // message provides detail about the error
            }
        }
    }
     

