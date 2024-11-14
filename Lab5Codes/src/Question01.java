class Parent {
    // fields and methods
    String name;
    Parent() {}
}

class Child1 extends Parent {
    // fields and methods
    Child1() {}
    Child1(String name) {
        this.name = name;
    }
}

class Child2 extends Parent {
    // fields and methods
    Child2() {}
    Child2(String name) {
        this.name = name;
    }
}

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    private void swapSameType(T1 first, T2 second) {
        this.first = (T1) second;
        this.second = (T2) first;
    }


    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }
    public T2 getSecond() {
        return second;
    }

    public Pair<T1, T2> getter() {
        return new Pair<>(first, second);
    }

    public <T1, T2> void swap() {
        Class<?> classA = first.getClass();
        Class<?> classB = second.getClass();
        if((first.getClass() == second.getClass())) {
            swapSameType(first, second);
            return;
        }
    }

}

class Main {
    public static void main(String[] args) {
        Parent child1 = new Child1("Trump");
        Parent child2 = new Child2("Harris");
        Pair<Parent, Parent> pair = new Pair<>(child1, child2);
        pair.swap(); // can swap the two values
        System.out.println(pair.getFirst().name);

        Pair<String, Integer> another = new Pair<>("str", 114514);
        another.swap(); // do nothing
        System.out.println(another.getFirst());
    }
}