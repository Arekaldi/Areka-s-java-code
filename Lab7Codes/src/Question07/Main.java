package Question07;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            copyFile("hello.txt", "studentInfo.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void copyFile (String sourceFile, String targetFile) throws IOException {
        // your implementation
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(sourceFile)));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(targetFile)));
        int byteData;
        while((byteData = bis.read()) != -1)
            bos.write(byteData);
        bis.close();
        bos.close();
    }
}