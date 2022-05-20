package MP;

import java.io.FileNotFoundException;

public class StudentDBDemo {

    public static void main(String[] args) {

        StudentDB.MAX_LENGTH = 10;
        StudentDB.shouldSaveChanges = true;
        StudentDB.databasePath = "database.dat";

        try {
            StudentDB.readSavedData();
        } catch (FileNotFoundException e) {
            StudentDB.initializeDefaultData(defaultData());
        }

        App app = new App();
        app.initialize(args);
    }

    public static StudentDB defaultData() {

        StudentDB database = new StudentDB();
        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Berlin, Russia"));
        return database;

    }
}
