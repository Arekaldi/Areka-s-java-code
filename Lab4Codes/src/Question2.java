class Super {
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Super sup = new Sub(); // upcasting
        System.out.println("sup.field = " + sup.field +
                ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field +
                ", sub.getField() = " + sub.getField() +
                ", sub.getSuperField() = " + sub.getSuperField());
    }
}