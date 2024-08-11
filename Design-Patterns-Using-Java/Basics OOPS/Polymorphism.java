class Adder {
    private int sum;

    public Adder() {
        this.sum = 0;
    }

    // Overloaded method for incrementing by a specific value
    public void increment(int a) {
        this.sum += a;
    }

    // Overloaded method for incrementing by 1
    public void increment() {
        this.sum += 1;
    }

    public int getValue() {
        return this.sum;
    }
}

public class Polymorphism {

    public static void main(String[] args) {
        Adder a = new Adder();
        a.increment(10);
        a.increment();
        System.out.println(a.getValue());
    }
}

/* 
11 
*/