package MP.interfaces;

import MP.StudentData;

public interface DBInterface {

    abstract boolean addData(StudentData dbd);

    abstract boolean deleteData(String name, int SAISID);

    abstract StudentData[] searchData(String toSearch);

    abstract void showData();

    abstract boolean editData(String name, int SAISID);

}