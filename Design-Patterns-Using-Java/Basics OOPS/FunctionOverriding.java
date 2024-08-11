class Person {
    protected String name;
    protected String oath;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return "Person: " + name + ":" + oath;
    }

    public void setOath() {
        this.oath = "Always tell truth";
    }
}

class Citizen extends Person {
    private int id;

    public Citizen(String name, int id) {
        super(name);
        this.id = id;
    }

    public void setOath() {
        this.oath = "Country comes first";
    }
}

public class FunctionOverriding {
    public static void main(String[] args) {
        Person p = new Person("John");
        p.setOath();
        System.out.println(p.toString());

        Citizen c = new Citizen("Smith", 31);
        c.setOath();
        System.out.println(c.toString());
    }
}
/* 
Person: John:Always tell truth
Person: Smith:Country comes first
 */