public class Singleton {
    private static final Singleton uniqueInstance = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        return uniqueInstance;
    }
    public void foo() {
        System.out.println("Aha!");
    }
    static {
        SingletonTest test = new SingletonTest();
        test.TestSingletonFoo();
    }
    public static void main(String[] args) {}
}

class SingletonTest {
    public void TestSingletonFoo() {
        Singleton singletonPtr = Singleton.getInstance();
        singletonPtr.foo();
    }
}
