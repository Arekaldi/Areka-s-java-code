public class Box<T extends Number> {
    // other fields and methods ...
    private T number;
    public Box(T number) {
        this.number = number;
    }
    public void setNumber(T number) {
        this.number = number;
    }
    private Number compareTo(Box<? extends Number> other) {
        Double d1 = Double.parseDouble(number.toString());
        Double d2 = Double.parseDouble(other.number.toString());
        return d1.compareTo(d2);
    }
    public static Number compareBoxes(Box<? extends Number> b1, Box<? extends Number> b2) {
        // your implementation
        return b1.compareTo(b2);
    }
    // other fields and methods ...
    public static void main(String[] args) {
        Long l = 1l << 62;
        Double d = l * 1.0;
        // Long 和 Double 比较就会损失精度，其他情况没有问题
        Box<Long> box1 = new Box<>(l);
        Box<Double> box2 = new Box<>(d);
        System.out.println(Box.compareBoxes(box1, box2));
    }
}