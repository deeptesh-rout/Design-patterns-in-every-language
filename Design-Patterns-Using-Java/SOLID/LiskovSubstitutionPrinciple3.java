
class Rectangle {
    private int height;
    private int width;

    public Rectangle(int l, int w) {
        this.height = l;
        this.width = w;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
}

class Square extends Rectangle {
    public Square(int l) {
        super(l, l);
    }

    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }

    @Override
    public void setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h);
    }
}

public class LiskovSubstitutionPrinciple3 {
    public static void testRectangle() {
        Rectangle r = new Rectangle(10, 20);
        testRect(r);
    }

    public static void testSquare() {
        Square s = new Square(10);
        s.setWidth(20);
        testRect(s);
    }

    private static void testRect(Rectangle rect) {
        rect.setHeight(10);
        rect.setWidth(20);
        if(200 == rect.getHeight() * rect.getWidth())
            System.out.println("success");
        else
            System.out.println("failure");
    }

    public static void main(String[] args) {
        testRectangle();
        testSquare();
    }
}

/*
success
failure
*/
