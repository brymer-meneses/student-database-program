package MP;

import MP.linkedList.LinkedList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * Database is an extension of our own custom implementation ot the linked list data
 * structure which allows for seamless reading and writing from a specific file.
 *
 * This allows the list of StudentData to be saved and read easily.
 */
public class Database extends LinkedList<StudentData> implements Serializable {

    /**
     * Specifies the path to which the data is stored.
     */
    private static final String databasePath = "database.dat";

    /**
     * Writes the changes of the database to the file.
     */
    public void writeChangesToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(databasePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();

        } catch (Exception ex) {
            throw new java.lang.Error(String.format("Error reading %s, recieved the following error: %s", databasePath, ex.getMessage()));
        }

    }

    /**
     * Reads the database.dat file and returns the data inside
     * it. This will fail when the file is not found.
     *
     * @return the data that is stored in "database.dat"
     */
    public static Database readSavedFile() {

        try {
            FileInputStream fileIn = new FileInputStream(databasePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return (Database) obj;

        } catch (Exception ex) {
            throw new java.lang.Error("Error database.dat is not found");
        }

    }

    /**
     * @return whether `database.dat` exists
     */
    public static boolean isSavedToDisk() {
        File f = new File(databasePath);
        return f.exists() && !f.isDirectory();
    }
}
