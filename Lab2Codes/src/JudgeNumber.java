import java.util.Scanner;
public class JudgeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Number = scanner.nextLine();
        int len = Number.length();
        if(len < 1) {
            System.err.println("The length of the number is less than 1");
            return;
        }
        for(int i = 0; i < len; ++i) {
            if(Number.charAt(i) < '0' || Number.charAt(i) > '9') {
                System.err.println("The number contains non-digit characters");
                return;
            }
        }
        if(len > 1 && Number.charAt(0) == '0') {
            int num = 0;
            int now = 0;
            while(Number.charAt(now++) == '0')
                num++;
            if(num != 0) {
                System.out.println("The number has " + num + " leading zeros");
                return;
            }
        }
        StringBuffer reverseNumber = new StringBuffer();
        reverseNumber = reverseNumber.append(Number).reverse();
        String reversedNumber = reverseNumber.toString();
        if(Number.equals(reversedNumber)) {
            System.out.println("The number is a palindrome");
        } else
            System.out.println("The number is not a palindrome");
    }
}
