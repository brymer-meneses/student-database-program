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
        database.addData(new StudentData("name1",1,11,"address1"));
        //database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Berlin, Russia"));
        database.addData(new StudentData("name2",2,22,"address2"));
        database.addData(new StudentData("name3",3,33,"address3"));
        database.addData(new StudentData("name4",4,44,"address4"));
        database.addData(new StudentData("name5",5,55,"address5"));        
        return database;

    }
}
