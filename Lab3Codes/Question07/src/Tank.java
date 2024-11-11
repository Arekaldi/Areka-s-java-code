public class Tank extends Vehicle {
    Tank() {
        engine = new Engine(1, "Diesel");
    }
    Tank(int numOfWheels, int diameter, int numOfPassengers, String wheelType) {
        this();
        this.numOfWheels = numOfWheels;
        wheels = new Wheel[numOfWheels];
        for (int i = 0; i < numOfWheels; i++) {
            wheels[i] = new Wheel(diameter, wheelType);
        }
        this.numOfPassengers = numOfPassengers;
        this.passenger = new Person[numOfPassengers];
    }
    public void setter(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }
    public void setDriver(Person driver) {
        this.driver = driver;
    }
    public void setPassenger(Person... passenger) {
        if (numOfPassengers >= 0)
            System.arraycopy(passenger, 0, this.passenger, 0, numOfPassengers);
    }

    public void getDriverAndPassengers() {
        System.out.println("Driver and passengers of Tank:");
        System.out.println("Driver: " + driver.name);
        for (int i = 0; i < numOfPassengers; i++) {
            System.out.println("Passenger " + (i + 1) + ": " + passenger[i].name);
        }
    }

    public void getInfo() {
        System.out.println("Tank Information:");
        getDriverAndPassengers();
        engine.getInfo();
        System.out.println("Number of wheels: " + numOfWheels);
        wheels[0].getInfo();
        for (int i = 0; i < numOfWheels; i++) {
            System.out.println("Wheel " + (i + 1) + ": " + wheels[i].diameter);
        }
    }
}
