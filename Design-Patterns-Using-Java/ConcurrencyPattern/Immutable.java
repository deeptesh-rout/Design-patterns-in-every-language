final class ImmutablePerson {
    private final String name;
    private final int age;
    private final String gender;

    public ImmutablePerson(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

public final class Immutable {
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("John Doe", 30, "Male");
        ImmutablePerson newPerson = new ImmutablePerson("John Doe", 31, "Male");

        System.out.println(person);
        System.out.println(newPerson);
        /* 
        person.age = 32;
        Immutable.java:32: error: age has private access in ImmutablePerson
    */
    }
}

/*
     public String setName(String newName) {
        name = newName;
    }
 */