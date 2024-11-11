public class Rectangle extends Shape {
    public Rectangle() {}
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public String toString() {
        return "Rectangle";
    }
    public double calcArea() {
        return a * b;
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
