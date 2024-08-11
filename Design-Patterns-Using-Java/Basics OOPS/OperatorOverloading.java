class Rectangle {
    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public double area() {
        return length * breadth;
    }

    public double perimeter() {
        return 2 * (length + breadth);
    }

    // Overloading + operator
    public Rectangle add(Rectangle rec) {
        return new Rectangle(this.length + rec.length, this.breadth + rec.breadth);
    }

    // Overloading - operator
    public Rectangle subtract(Rectangle rec) {
        return new Rectangle(Math.abs(this.length - rec.length), Math.abs(this.breadth - rec.breadth));
    }

    // Overloading == operator
    public boolean equals(Rectangle rec) {
        return this.length == rec.length && this.breadth == rec.breadth;
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "Rectangle length and width: " + length + " " + breadth;
    }
}

public class OperatorOverloading {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 6);
        Rectangle r2 = new Rectangle(10, 6);

        System.out.println("Is r1 == r2 ? " + r1.equals(r2));

        Rectangle r3 = r1.add(r2);
        Rectangle r4 = r1.subtract(r2);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
    }
}

/* 
Is r1 == r2 ? false
Rectangle length and width: 4.0 6.0
Rectangle length and width: 10.0 6.0
Rectangle length and width: 14.0 12.0
Rectangle length and width: 6.0 0.0
*/