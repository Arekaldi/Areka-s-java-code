public class Rhombus extends Shape {
    public Rhombus() {}
    public Rhombus(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return "Rhombus";
    }

    public double calcArea() {
        return a * b * 0.50;
    }

    public double[] getter() {
        return new double[]{a, b};
    }

    public void setter(double a, double b) {
        if(a < 0 || b < 0) {
            throw new IllegalArgumentException("Length cannot be negative.");
        }
        else {
            this.a = a;
            this.b = b;
        }
    }
}
