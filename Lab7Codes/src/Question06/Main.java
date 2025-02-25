package Question06;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            addLineNo("inputFile.txt", "outputFile.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void addLineNo(String inputPath, String outputPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                writer.write(lineNumber + ": " + line);
                writer.newLine();
                lineNumber++;
            }
        }
    }
}