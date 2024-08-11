abstract class AddDataTemplate {
    final void addData() {
        open();
        add();
        close();
    }

    abstract void open();
    abstract void add();
    abstract void close();
}

class AddDataToFile extends AddDataTemplate {
    @Override
    void open() {
        System.out.println("Open file.");
    }

    @Override
    void add() {
        System.out.println("Add data to file.");
    }

    @Override
    void close() {
        System.out.println("Close file");
    }
}

class AddDataToDB extends AddDataTemplate {
    @Override
    void open() {
        System.out.println("Open Database.");
    }

    @Override
    void add() {
        System.out.println("Add data to Database.");
    }

    @Override
    void close() {
        System.out.println("Close Database.");
    }
}

public class TemplatePatternData {
    public static void main(String[] args) {
        AddDataTemplate addDataToDB = new AddDataToDB();
        addDataToDB.addData();
    }
}

/* 
Open Database.
Add data to Database.
Close Database. 
*/