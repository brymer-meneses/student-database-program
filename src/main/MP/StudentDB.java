package MP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import MP.core.DBInterface;
import MP.core.LinkedList;

public class StudentDB implements DBInterface, Serializable {

    private static LinkedList<StudentData> database;

    private final int MAX_LENGTH = 10;
    private final static String filename = "database.dat";

    public StudentDB() {
        database = new LinkedList<StudentData>();
    }

    public int length() {
        return database.length;
    }

    @Override
    public boolean addData(StudentData dbd) {

        if (isDuplicateOfDatabase(dbd)) {
            return false;
        }
        if (database.length + 1 > MAX_LENGTH) {
            return false;
        }

        database.append(dbd);
        updateSavedData();
        return true;
    }

    @Override
    public boolean deleteData(String name, int SAISID) {

        StudentData element = new StudentData(name, SAISID, 1, "address");

        for (int i = 0; i < database.length; i++) {

            if (database.get(i).isEqualTo(element)) {
                database.delete(i);
                updateSavedData();
                return true;
            }
        }

        return false;
    }

    @Override
    public StudentData[] searchData(String toSearch) {
        StudentData data[] = new StudentData[MAX_LENGTH];

        int count = 0;
        for (int i = 0; i < database.length; i++) {
            StudentData element = database.get(i);

            if (element.keywordInEntries(toSearch)) {
                data[count] = element;
            }

            count++;
        }

        return data;
    }

    @Override
    public void showData() {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean editData(String name, int SAISID) {
        // TODO Auto-generated method stub
        return false;
    }

    public StudentData getData(int index) {
        return database.get(index);
    }

    public boolean isDuplicateOfDatabase(StudentData element) {

        for (int i = 0; i < database.length; i++) {

            if (database.get(i).isEqualTo(element)) {
                return true;
            }
        }
        return false;
    }

    public static void initializeDatabase(StudentDB database) {

        try {

            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(database);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static StudentDB readSavedData() {

        try {

            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return (StudentDB) obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void updateSavedData() {

        try {

            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
