class InputMismatchException extends Exception {
    public InputMismatchException(String message) {
        super(message);
    }
}

class IntegerDivide {
    public static <T extends Number> int divide(T dividend, T divisor) throws Exception {
        if(dividend.getClass() != Integer.class || divisor.getClass() != Integer.class) {
            throw new InputMismatchException("输入必须为整数");
        }

        if(divisor.equals(0)) {
            throw new ArithmeticException("除数不能为0");
        }

        int dividendInt = dividend.intValue();
        int divisorInt = divisor.intValue();

        return dividendInt / divisorInt;
    }
}

public class Divide {
    public static void main(String[] args) {
        try {
            System.out.println(IntegerDivide.divide(10, 2));
//            System.out.println(IntegerDivide.divide(10, 0.5));
//            System.out.println(IntegerDivide.divide(10, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("程序结束");
        }
    }
}
