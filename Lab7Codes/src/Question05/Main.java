package Question05;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            removeComments("inputFile.java", "outputFile.java");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void removeComments(String inputPath, String outputPath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            boolean inBlockComment = false;

            while ((line = reader.readLine()) != null) {
                if (inBlockComment) {
                    if (line.contains("*/")) {
                        inBlockComment = false;
                        line = line.substring(line.indexOf("*/") + 2);
                    } else {
                        continue;
                    }
                }

                if (line.contains("/*")) {
                    inBlockComment = true;
                    line = line.substring(0, line.indexOf("/*"));
                }

                if (line.contains("//")) {
                    line = line.substring(0, line.indexOf("//"));
                }

                if (!line.trim().isEmpty()) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }
    }
}