package MP;

import java.io.File;

/**
 * This is the class that contains the main method in the app.
 */
public class StudentDBDemo {

    public static void main(String[] args) {

        Database database = new Database();
        database.append(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Russia"));
        database.append(new StudentData("Archimedes of Syracuse", 314, 287314152,"Syracuse, Italy"));
        database.append(new StudentData("Max Planck",66260,19476626,"Humboldtstrasse 13,Heidelberg, Germany"));
        database.append(new StudentData("Katherine Johnson",2020,19581969,"1400 Bell St. Sacramento, California"));
        database.append(new StudentData("Alan Turing",1947,01000001,"96 Euston Road, London"));

        if (! new File("database.dat").exists()) {
            database.writeChangesToFile();
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
//    public static StudentDB defaultData() {
//
//        StudentDB database = new StudentDB();
//        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Russia"));
//        database.addData(new StudentData("Archimedes of Syracuse", 314, 287314152,"Syracuse, Italy"));
//        database.addData(new StudentData("Max Planck",66260,19476626,"Humboldtstrasse 13,Heidelberg, Germany"));
//        database.addData(new StudentData("Katherine Johnson",2020,19581969,"1400 Bell St. Sacramento, California"));
//        database.addData(new StudentData("Alan Turing",1947,01000001,"96 Euston Road, London"));
//        database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Russia"));
//        database.addData(new StudentData("Archimedes of Syracuse", 314, 287314152,"Syracuse, Italy"));
//        database.addData(new StudentData("Max Planck",66260,19476626,"Humboldtstrasse 13,Heidelberg, Germany"));
//        database.addData(new StudentData("Katherine Johnson",2020,19581969,"1400 Bell St. Sacramento, California"));
//        database.addData(new StudentData("Alan Turing",1947,01000001,"96 Euston Road, London"));
//        //database.addData(new StudentData("Leonhard Euler", 045612, 17150234, "St. Petersburg, Berlin, Russia"));
//        return database;
//
//    }
}

