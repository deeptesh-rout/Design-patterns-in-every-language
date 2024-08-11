class Database {
    public Database() {
        System.out.println("Database created");
    }

    public void addData(String data) {
        System.out.println(data);
    }
}

//public 
class Singleton {
    private static volatile Singleton instance;  // Volatile keyword for double-checked locking
    private static Database db;
    private static final Object lock = new Object();  // Add a lock for thread synchronization

    private Singleton() {
        db = new Database();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (lock) {  // Acquire the lock
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void addData(String data) {
        db.addData(data);
    }
}

public class DoubleChecking {
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