package MP;

public interface DBInterface {

    abstract boolean addData(StudentData dbd);

    abstract boolean deleteData(String name);

    abstract StudentData[] searchData(String toSearch);

    abstract void showData();

    abstract boolean editData(String name);

}