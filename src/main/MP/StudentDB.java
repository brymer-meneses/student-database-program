package MP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.File;

import MP.core.LinkedList;
import MP.interfaces.DBInterface;

public class StudentDB implements DBInterface, Serializable {

    private LinkedList<StudentData> database;

    public final  int maxStorageLength = 10;
    private final static String databasePath = "database.dat";
    private final static boolean shouldSaveChanges = true;

    public StudentDB() {
        database = new LinkedList<StudentData>();
    }

    public int length() {
        return database.length;
    }

    public static boolean savedDatabaseExists() {
        if (new File(databasePath).exists()) {
            return true;
        } else {
            return false;
        }

    }

    private String currentNameEdit;
    private int currentSaisIdEdit;
    private String currentAddressEdit;
    private int currentStudentNumberEdit;

    public void setCurrentEdit(String currentNameEdit, int currentSaisIdEdit, int currentStudentNumberEdit, String currentAddressEdit) {
        this.currentNameEdit = currentNameEdit;
        this.currentSaisIdEdit = currentSaisIdEdit;
        this.currentStudentNumberEdit = currentStudentNumberEdit;
        this.currentAddressEdit = currentAddressEdit;
    }

    @Override
    public boolean addData(StudentData dbd) {

        if (isDuplicateOfDatabase(dbd)) {
            return false;
        }
        if (database.length + 1 > maxStorageLength) {
            return false;
        }

        database.append(dbd);
        updateSavedData();
        return true;
    }

    @Override
    public boolean deleteData(String name, int SAISID) {

        for (int i = 0; i < database.length; i++) {

            if (database.get(i).name.equals(name) && database.get(i).saisId == SAISID) {
                database.delete(i);
                updateSavedData();
                return true;
            }
        }

        return false;
    }

    public LinkedList<StudentData> searchData(String toSearch) {
        LinkedList<StudentData> results = new LinkedList<StudentData>();

        for (int i = 0; i < database.length; i++) {
            StudentData element = database.get(i);

            if (Utils.keywordInEntries(element, toSearch)) {
                results.append(element);
            }
        }

        return results;
    }

    @Override
    public LinkedList<StudentData> showData() {
        LinkedList<StudentData> results = new LinkedList<StudentData>();
        for (int i = 0; i < database.length; i++) {
            results.append(database.get(i));
        }
        return results;
    }

    @Override
    public boolean editData(String name, int saisId) {
        StudentData element;
        for (int i=0; i < database.length; i++) {
            element = database.get(i);
            if (element.name.equals(name) && element.saisId == saisId) {
                element.name = currentNameEdit;
                element.saisId = currentSaisIdEdit;
                element.address = currentAddressEdit;
                element.studentNumber = currentStudentNumberEdit;
                updateSavedData();
                return true;
            }
        }

        return false;
    }

    public StudentData getData(int index) {
        try {
            return database.get(index);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isDuplicateOfDatabase(StudentData element) {

        for (int i = 0; i < database.length; i++) {

            if (Utils.isEqual(element , database.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void initializeDefaultData(StudentDB database) {

        try {
            FileOutputStream fileOut = new FileOutputStream(databasePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(database);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static StudentDB readSavedData() {

        try {

            FileInputStream fileIn = new FileInputStream(databasePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return (StudentDB) obj;

        } catch (Exception ex) {
            throw new java.lang.Error("Error: " + ex.getMessage());
        }

    }

    private void updateSavedData() {
        if (!shouldSaveChanges)
            return;

        try {

            FileOutputStream fileOut = new FileOutputStream(databasePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void getLatestData() {
        database = readSavedData().database;
    }
}
