import java.sql.Driver;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(4, 80, 1, "rubber");
        car.setDriver(new Person("John", 35, "Male"));
        car.setPassenger(new Person("Mary", 25, "Female"));
        car.getDriverAndPassengers();
        Tank tank = new Tank(10, 150, 2, "iron");
        tank.setDriver(new Person("大头兵1号", 21, "Male"));
        tank.setPassenger(new Person("大头兵2号", 22, "Male"), new Person("大头兵3号", 19, "Male"));
        tank.getDriverAndPassengers();

        Person brother = new Person("哥哥", 25, "Male");
        Person sister = new Person("妹妹", 23, "Female");

        Motorbike motorbike = new Motorbike(2, 100, 1, "rubber");
        motorbike.setDriver(brother);
        motorbike.setPassenger(sister);
        motorbike.getInfo();

        sister.say("不像我，我只会心疼 giegie~");
    }
}
