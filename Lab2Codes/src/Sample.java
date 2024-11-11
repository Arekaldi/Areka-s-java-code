public class Sample {
    int x;

    void test(int a) {}
    int test(int a, int b) {
        return a;
    }

    public static void main(String[] args) {
        Sample t = new Sample();
        System.out.println(t.x);
    }
}
