// Define AddDataTemplate
class AddDataTemplate {
    addData() {
        this.open();
        this.add();
        this.close();
    }

    open() {
        throw new Error("open method must be implemented");
    }

    add() {
        throw new Error("add method must be implemented");
    }

    close() {
        throw new Error("close method must be implemented");
    }
}

// Define AddDataToFile extending AddDataTemplate
class AddDataToFile extends AddDataTemplate {
    open() {
        console.log("Open file.");
    }

    add() {
        console.log("Add data to file.");
    }

    close() {
        console.log("Close file");
    }
}

// Define AddDataToDB extending AddDataTemplate
class AddDataToDB extends AddDataTemplate {
    open() {
        console.log("Open Database.");
    }

    add() {
        console.log("Add data to Database.");
    }

    close() {
        console.log("Close Database.");
    }
}

// Client code
const addDataToDB = new AddDataToDB();
addDataToDB.addData();

/*
Open Database.
Add data to Database.
Close Database.
*/