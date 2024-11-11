interface Inter {
    void show();
}

class Outer {
    public static Inter method() {
        return new Inner();
    }

    private static class Inner implements Inter {
        public void show() {
            System.out.println("DuluDulu");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.method().show();
    }
}