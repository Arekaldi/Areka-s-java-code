class Person {
    int age;
    String name;
    char sex;
    /* "M" for male, and "F" for female */
    void setAge(int age) {
        if(age < 0 || age > 130) {
            System.err.println("Age must be between 0 and 130");
            return;
        }
        this.age = age;
    }
    Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        setAge(age);
    }
    int getAge() {
        return this.age;
    }
    void work() {
        System.out.println("working");
    }
    void showAge() {
        System.out.println(this.age);
    }
}
public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Person("John", 'M', 25);
        person1.setAge(30);
        person1.showAge();
        Person person2 = new Person("Taylor Swift", 'F', 35);
        person2.setAge(131);
        person2.showAge();
    }
}