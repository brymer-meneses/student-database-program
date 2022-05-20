package MP;

import java.security.KeyException;

import MP.core.LinkedList;

public class StudentDB implements DBInterface {

    private LinkedList<StudentData> database;

    private final int MAX_LENGTH = 10;

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
        return true;
    }

    @Override
    public boolean deleteData(String name, int SAISID) {

        StudentData element = new StudentData(name, SAISID, 1, "address");

        for (int i = 0; i < database.length; i++) {

            if (database.get(i).isEqualTo(element)) {
                database.delete(i);
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

}
