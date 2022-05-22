package MP.interfaces;

import MP.StudentData;
import MP.core.LinkedList;

public interface DBInterface {

    abstract boolean addData(StudentData dbd);

    abstract boolean deleteData(String name, int SAISID);

    abstract LinkedList<StudentData> searchData(String toSearch);

    abstract LinkedList<StudentData> showData();

    abstract boolean editData(String name, int SAISID);

}