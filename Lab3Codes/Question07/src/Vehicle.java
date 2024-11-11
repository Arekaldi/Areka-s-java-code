abstract public class Vehicle {
    protected int numOfWheels;
    protected int numOfPassengers;
    protected Person driver;
    protected Person[] passenger;
    protected Engine engine;
    protected Wheel[] wheels;
    Vehicle() {}
    Vehicle(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    abstract protected void setter(int numOfWheels);
    abstract protected void setDriver(Person driver);
    abstract protected void setPassenger(Person[] passenger);
    abstract protected void getDriverAndPassengers();
    abstract protected void getInfo();
}