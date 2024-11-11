class A {
    A() {

    }
    final public void Test() {}
}

final class B extends A {
    B() {

    }
    public void Test() {

    }
}
public class FinalTest {
    public static void main(String[] args) {
        String a = "Hello2";
        final String b = "Hello";
        String c = b + "2";
        String d = "Hello";
        String e = d + "2";
        System.out.println((a == c));
        System.out.println((a == e));
        System.out.println(a.equals(e));
    }
}
