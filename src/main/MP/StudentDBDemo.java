package MP;

import java.io.File;

public class StudentDBDemo {

    private final static String filename = "database.dat";
    private final static boolean shouldOverwriteSavedData = true;

    public static void main(String[] args) {

        File savedData = new File(filename);

        if (savedData.exists() && shouldOverwriteSavedData) {
            StudentDB.readSavedData();
        } else {
            StudentDB.initializeDatabase(defaultData());
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
