public class Wheel {
    double diameter;
    String wheelType;
    Wheel() {}
    Wheel(double diameter, String wheelType) {
        this.diameter = diameter;
        this.wheelType = wheelType;
    }
    public void setter(double diameter) {
        this.diameter = diameter;
    }

    public void getInfo() {
        System.out.println("Diameter of the wheel is: " + diameter + "cm");
    }
}
