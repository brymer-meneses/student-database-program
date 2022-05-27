package MP;

import MP.linkedList.LinkedList;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Database extends LinkedList<StudentData> implements Serializable {

    private static final String databasePath = "database.dat";

    public void writeChangesToFile() {

        try {

            FileOutputStream fileOut = new FileOutputStream(databasePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();

        } catch (Exception ex) {
            throw new java.lang.Error("Error database.dat is not found");
        }

    }

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

}
