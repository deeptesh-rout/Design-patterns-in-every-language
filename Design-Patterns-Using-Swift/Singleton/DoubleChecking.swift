import Foundation

class Database {
    init() {
        print("Database created")
    }
    
    func addData(_ data: String) {
        print(data)
    }
}

class Singleton {
    private static var instance: Singleton?
    private var db: Database
    private static let lock = NSLock()  // NSLock for thread synchronization
    
    private init() {
        db = Database()
    }
    
    static func getInstance() -> Singleton {
        if instance == nil {
            lock.lock()  // Acquire the lock
            defer {
                lock.unlock()  // Release the lock when leaving the scope
            }
            if instance == nil {
                instance = Singleton()
            }
        }
        return instance!
    }
    
    func addData(_ data: String) {
        db.addData(data)
    }
}

// Client code
let s1 = Singleton.getInstance()
let s2 = Singleton.getInstance()

print(ObjectIdentifier(s1))
print(ObjectIdentifier(s2))

s2.addData("Hello, world!")

/*
Database created
DoubleChecking.Singleton
DoubleChecking.Singleton
Hello, world!
*/