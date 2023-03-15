abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    public double a;
    public double b;
    public double c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double perimeter = getPerimeter();
        double s = perimeter / 2;
        return Math.sqrt((s * (s - a) * (s - b) * (s - c)));
    }
}

class Rectangle extends Shape {

    public double a;
    public double b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return a + b + a + b;
    }

    @Override
    public double getArea() {
        return a * b;
    }
}

class Circle extends Shape {

    public double a;

    Circle(double a) {
        this.a = a;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * a;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(a, 2);
    }
}

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(3, 4, 5);
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.format("A circle has a radius = %.0f: perimeter = %f, area = %f%n", circle.a, circle.getPerimeter(), circle.getArea());
        System.out.format("A triangle has three sides a = %.0f, b = %.0f and c = %.0f: perimeter = %f, area = %f%n", triangle.a, triangle.b, triangle.c, triangle.getPerimeter(), triangle.getArea());
        System.out.format("A rectangle has two different sides a = %.0f, b = %.0f: perimeter = %f, area = %f", rectangle.a, rectangle.b, rectangle.getPerimeter(), rectangle.getArea());
    }
}