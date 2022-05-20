package MP;

public class StudentDBDemo {

    public static void main(String[] args) {

        StudentDB.readSavedData();

        App app = new App();
        app.initialize(args);
    }

    public static StudentDB defaultData() {

        StudentDB database = new StudentDB();
        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Berlin, Russia"));
        return database;

    }
}
