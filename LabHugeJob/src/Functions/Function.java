package Functions;

import java.io.File;
import java.util.regex.Pattern;

public class Function {

    public static boolean charIsDigitInRange(char char1, char char2, int lowerBound, int upperBound) {
        if(char1 >= '0' && char1 <= '9' && char2 >= '0' && char2 <= '9') {
            int charNum = (char1 - '0') * 10 + (char2 - '0');
            return charNum >= lowerBound && charNum <= upperBound;
        }
        return false;
    }
    public static boolean charIsLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static int getNumberByString(String str) {
        int res = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                res = res * 10 + (c - '0');
            }
        }
        return res;
    }
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumber(String str) {
        return str != null && NUMBER_PATTERN.matcher(str).matches();
    }

    public static void deleteDir(File src) {
        File[] files = src.listFiles();
        for (File file : files) {
            if(file.isFile()){
                file.delete();
            }else{
                deleteDir(file);
            }
        }
        src.delete();
    }
}
