public abstract class Shape {
    protected double a;
    protected double b;

    public Shape() { this(0.0, 0.0); }
    public Shape(double a, double b) {
        this.a = a;
        this.b = b;
    }

    /** calcArea
     * 计算形状的面积
     * @return 面积
     */
    abstract public double calcArea();

    /* 其他必要的方法，比如 getter 和 setter */

    abstract protected double[] getter();
    abstract protected void setter(double a, double b);
}