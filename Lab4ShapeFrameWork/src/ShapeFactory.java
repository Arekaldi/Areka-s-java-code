public class ShapeFactory {
    public Shape makeShape(ShapeType type, double a, double b) throws IllegalArgumentException {
        switch (type) {
            case Rectangle: {
                Rectangle rectangle = new Rectangle();
                rectangle.setter(a, b);
                return rectangle;
            }
            case Ellipse: {
                Ellipse ellipse = new Ellipse();
                ellipse.setter(a, b);
                return ellipse;
            }
            case Rhombus: {
                Rhombus rhombus = new Rhombus();
                rhombus.setter(a, b);
                return rhombus;
            }
        }
        return null;
    }

    public Shape randomNextShape() {
        int randomShapeIndex = (int)(Math.random() * Math.random() * 1000);
        ShapeType randomShapeType = ShapeType.values()[randomShapeIndex % 3];
        double a = Math.random() * 100;
        double b = Math.random() * 100;
        try {
            return makeShape(randomShapeType, a, b);
        } catch (IllegalArgumentException e) {
            return randomNextShape();
        }
    }
}

enum ShapeType {
    Rectangle, Ellipse, Rhombus;
    ShapeType() {}
}