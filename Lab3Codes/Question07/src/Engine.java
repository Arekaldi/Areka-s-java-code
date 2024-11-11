public class Engine {
    int engineNumber;
    String engineType;

    Engine() {}
    Engine(int engineNumber, String engineType) {
        this.engineNumber = engineNumber;
        this.engineType = engineType;
    }

    public void setter(int engineNumber, String engineType) {
        this.engineNumber = engineNumber;
        this.engineType = engineType;
    }

    public void getInfo() {
        System.out.println("The engine number is: " + engineNumber);
        System.out.println("The engine type is: " + engineType);
    }
}
