public class Overload {
    Overload(int m) {}
    Overload(double m) {}
    int Overload(int m) {
        return 0;
    }
    void Overload(double m) {}
    public static void main(String[] args) {
        Overload p = new Overload(5.5);
    }
}
