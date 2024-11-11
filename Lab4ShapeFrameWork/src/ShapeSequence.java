public class ShapeSequence {
    private Shape[] shapes;
    int shapeSize;

    public ShapeSequence(int size) {
        if(size < 0)
            size = 0;
        shapes = new Shape[size];
        shapeSize = 0;
    }

    public void add(Shape shape) {
        if(shapeSize < shapes.length - 1)
            shapes[shapeSize++] = shape;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < shapeSize; i++) {
            result.append(shapes[i].toString().toLowerCase());
            if(i < shapeSize - 1)
                result.append(", ");
        }
        return result.toString() + "]";
    }

    public interface iterator  {
        boolean isEnd();
        Shape current() throws IndexOutOfBoundsException;
        void moveNext();
        boolean equals(Object o);
    }

    public iterator createIterator() {
        return new SequenceIterator();
    }

    private class SequenceIterator implements iterator {
        int index = 0;
        SequenceIterator() {}
        SequenceIterator(int index) {
            this.index = index;
        }
        public boolean isEnd() {
            return index >= shapeSize;
        }
        public Shape current() throws IndexOutOfBoundsException {
            if(!isEnd())
                return shapes[index];
            else
                throw new IndexOutOfBoundsException("Index out of bounds");
        }
        public void moveNext() {
            if(!isEnd())
                index++;
        }
        public boolean equals(Object o) {
            if(o instanceof SequenceIterator) {
                Shape thisShape = shapes[index];
                Shape otherShape = ((SequenceIterator) o).current();
                return thisShape.equals(otherShape) && index == ((SequenceIterator) o).index;
            }
            return false;
        }

    }
}
