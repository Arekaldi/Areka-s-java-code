import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("23371041 李一鸣");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(input.equals("QUIT") == false) {
            System.out.println("Hello World!");
            input = scanner.nextLine();
        }
        System.out.println("----- Good Bye! -----");
    }
}