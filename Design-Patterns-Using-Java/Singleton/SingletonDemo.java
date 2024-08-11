class Database {
    public Database() {
        System.out.println("Database created");
    }

    public void addData(String data) {
        System.out.println(data);
    }
}

class Singleton {
    private static Singleton instance = null;
    private Database db;

    private Singleton() {
        db = new Database();
    }

    public static Singleton getInstance() {
        if (instance == null) {
        	instance = new Singleton();
        }
        return instance;
    }

    public void addData(String data) {
        db.addData(data);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        s2.addData("Hello, world!");
    }
}

/*
Database created
Singleton@7344699f
Singleton@7344699f
Hello, world!
*/
