import Foundation

class AddDataTemplate {
    final func addData() {
        open()
        add()
        close()
    }

    func open() {
        fatalError("Abstract method. Subclasses must implement open.")
    }

    func add() {
        fatalError("Abstract method. Subclasses must implement add.")
    }

    func close() {
        fatalError("Abstract method. Subclasses must implement close.")
    }
}

class AddDataToFile: AddDataTemplate {
    override func open() {
        print("Open file.")
    }

    override func add() {
        print("Add data to file.")
    }

    override func close() {
        print("Close file.")
    }
}

class AddDataToDB: AddDataTemplate {
    override func open() {
        print("Open Database.")
    }

    override func add() {
        print("Add data to Database.")
    }

    override func close() {
        print("Close Database.")
    }
}

// Client code.
let addDataToDB = AddDataToDB()
addDataToDB.addData()

/* 
Open Database.
Add data to Database.
Close Database. 
*/