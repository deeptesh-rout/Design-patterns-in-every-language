import java.util.ArrayList;
import java.util.List;

class Tyre {
    private String type;

    public Tyre(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Car {
    private String model;
    private List<Tyre> tyres;

    public Car(String model) {
        this.model = model;
        this.tyres = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            this.tyres.add(new Tyre("MRF"));
        }
    }

    public void display() {
        System.out.println("Car: " + model + ", Tyre: " + tyres.get(0).getType());
    }
}

public class CompositionRelationship {
    public static void main(String[] args) {
        Car car = new Car("BMW");
        car.display();
    }
}

/*
Car: BMW, Tyre: MRF
 */