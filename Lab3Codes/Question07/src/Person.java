public class Person {
    String name;
    int age;
    String gender;

    Person() {}
    Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void say(String message) {
        System.out.println(message);
    }
}
