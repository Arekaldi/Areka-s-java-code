import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Rhombus a = new Rhombus(3, 5);
        Rectangle b = new Rectangle(4, 5);
        Ellipse c = new Ellipse(9, 16);
        System.out.println(a.calcArea());
        System.out.println(b.calcArea());
        System.out.println(c.calcArea());
        System.out.println(Arrays.toString(c.getter()));
        c.setter(25, 100);
        c.setter(-1, 100);
    }
}
