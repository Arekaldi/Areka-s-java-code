public class ShapeFactoryTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape[] shapes = new Shape[]{shapeFactory.makeShape(ShapeType.Rectangle, 5, 5), shapeFactory.randomNextShape(), shapeFactory.randomNextShape(), shapeFactory.randomNextShape(), shapeFactory.randomNextShape()};
        for(Shape shape : shapes) {
            System.out.println(shape.calcArea());
        }
    }
}
