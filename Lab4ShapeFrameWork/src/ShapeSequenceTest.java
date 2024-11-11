public class ShapeSequenceTest {
    public static void main(String[] args) {
        ShapeSequence sequence = new ShapeSequence(5);
        ShapeSequence.iterator it =  sequence.createIterator();
        ShapeSequence.iterator it2 = sequence.createIterator();
        ShapeFactory sf = new ShapeFactory();
        sequence.add(sf.randomNextShape());
        sequence.add(sf.randomNextShape());
        System.out.println(sequence.toString());
        System.out.println(it.isEnd());
        System.out.println(it.current().toString().toLowerCase());
        it.moveNext();
        it2.moveNext();
        System.out.println(it.current().toString().toLowerCase());
        System.out.println(it2.current().toString().toLowerCase());
        System.out.println(it.equals(it2));
        it.moveNext();
        System.out.println(it.isEnd());
    }
}
