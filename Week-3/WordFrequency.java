
import java.io.*;
import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

       
        Map<String, Integer> wordCount = new LinkedHashMap<>();

        try {
            
            BufferedReader reader = new BufferedReader(
                    new FileReader("input.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

              
                String[] words = line.toLowerCase().split("\\W+");

                for (String word : words) {

                    if (!word.isEmpty()) {
                        wordCount.put(word,
                                wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            reader.close();

            
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("output.txt"));

            writer.write("Word Frequency Report");
            writer.newLine();
            writer.write("---------------------");
            writer.newLine();

            for (Map.Entry<String, Integer> entry :
                    wordCount.entrySet()) {

                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }

            writer.close();

            System.out.println("Word frequency calculated successfully!");
            System.out.println("Results saved in output.txt");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
