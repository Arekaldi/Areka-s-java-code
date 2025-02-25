package Question08;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            copyDirectory("src/Question03", "src/Question02");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void copyDirectory(String sourceDir, String targetDir) throws IOException {
        File source = new File(sourceDir);
        File target = new File(targetDir);

        if (!target.exists()) {
            target.mkdirs();
        }

        for (String file : source.list()) {
            File sourceFile = new File(source, file);
            File targetFile = new File(target, file);

            if (sourceFile.isDirectory()) {
                copyDirectory(sourceFile.getAbsolutePath(), targetFile.getAbsolutePath());
            } else {
                copyFile(sourceFile, targetFile);
            }
        }
    }

    public static void copyFile (File sourceFile, File targetFile) throws IOException {
        // your implementation
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFile));
        int byteData;
        while((byteData = bis.read()) != -1)
            bos.write(byteData);
        bis.close();
        bos.close();
    }
}