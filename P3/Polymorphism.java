abstract class Shape {
    abstract double area();
    public String toString() { return getClass().getSimpleName() + " area = " + String.format("%.2f", area()); }
}
class Circle extends Shape {
    double r; Circle(double r) { this.r = r; }
    double area() { return Math.PI * r * r; }
}
class Rectangle extends Shape {
    double l, b; Rectangle(double l, double b) { this.l = l; this.b = b; }
    double area() { return l * b; }
}
class Triangle extends Shape {
    double b, h; Triangle(double b, double h) { this.b = b; this.h = h; }
    double area() { return 0.5 * b * h; }
}

class AreaCalculator {
    double area(double r) { return Math.PI * r * r; }               
    double area(double l, double b) { return l * b; }               
    double area(double a, double b, double c) {                    
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}

class Payment {
    void pay(double amt) { System.out.println("Generic payment of " + amt); }
}
class CardPayment extends Payment {
    @Override void pay(double amt) { System.out.println("Paid " + amt + " by Credit/Debit Card (2% fee)"); }
}
class UpiPayment extends Payment {
    @Override void pay(double amt) { System.out.println("Paid " + amt + " via UPI (no fee)"); }
}
class CashPayment extends Payment {
    @Override void pay(double amt) { System.out.println("Paid " + amt + " in Cash"); }
}

public class Practical3 {
    public static void main(String[] args) {
        System.out.println("--- Overloading ---");
        AreaCalculator c = new AreaCalculator();
        System.out.printf("Circle: %.2f%n", c.area(5));
        System.out.printf("Rectangle: %.2f%n", c.area(4, 6));
        System.out.printf("Triangle: %.2f%n", c.area(3, 4, 5));

        System.out.println("\n--- Overriding (parent reference) ---");
        Shape[] shapes = { new Circle(3), new Rectangle(4, 5), new Triangle(6, 2) };
        for (Shape s : shapes) System.out.println(s);

        Payment[] payments = { new CardPayment(), new UpiPayment(), new CashPayment(), new Payment() };
        for (Payment p : payments) p.pay(1000);
    }
}
