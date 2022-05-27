package MP;

/**
 * This is the class that contains the main method in the app.
 */
public class StudentDBDemo {

    public static void main(String[] args) {

        // check if the file for saving the database does not
        // exist, if so, set the initial data.
        if (!StudentDB.savedDatabaseExists()) {
            StudentDB.initializeDefaultData(defaultData());
        }

        App app = new App();
        app.initialize(args);
    }

    /**
     * Initializes the default data that will be used in the program if the
     * database file is not found.
     *
     * @return StudentDB containing the default data
     */
    public static StudentDB defaultData() {

        StudentDB database = new StudentDB();
        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Russia"));
        database.addData(new StudentData("Archimedes of Syracuse", 314, 287314152,"Syracuse, Italy"));
        database.addData(new StudentData("Max Planck",66260,19476626,"Humboldtstrasse 13,Heidelberg, Germany"));
        database.addData(new StudentData("Katherine Johnson",2020,19581969,"1400 Bell St. Sacramento, California"));
        database.addData(new StudentData("Alan Turing",1947,01000001,"96 Euston Road, London"));   
        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Russia"));
        database.addData(new StudentData("Archimedes of Syracuse", 314, 287314152,"Syracuse, Italy"));
        database.addData(new StudentData("Max Planck",66260,19476626,"Humboldtstrasse 13,Heidelberg, Germany"));
        database.addData(new StudentData("Katherine Johnson",2020,19581969,"1400 Bell St. Sacramento, California"));
        database.addData(new StudentData("Alan Turing",1947,01000001,"96 Euston Road, London"));   
        //database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Berlin, Russia"));
        return database;

    }
}

