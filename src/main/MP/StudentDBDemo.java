package MP;

import java.io.File;

public class StudentDBDemo {

    private final static String filename = "database.dat";
    private final static boolean shouldOverwriteSavedData = true;

    public static void main(String[] args) {
        StudentDB database;

        File savedData = new File(filename);

        if (savedData.exists() && shouldOverwriteSavedData) {
            database = StudentDB.readSavedData();
        } else {
            database = loadDefaultData();
        }

        App app = new App();
        app.initialize(args, database);
    }

    public static StudentDB loadDefaultData() {

        StudentDB database = new StudentDB();
        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Berlin, Russia"));
        return database;

    }
}
