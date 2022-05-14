package MP;

public class StudentDB implements DBInterface {

    public StudentData head;
    public StudentData tail;

    @Override
    public boolean addData(StudentData dbd) {
        // TODO Auto-generated method stub

        if (head == null) {
            head = dbd;
            return false;
        } else {
            tail = head;

            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = dbd;
            tail = dbd;
            return true;
        }

    }

    @Override
    public boolean deleteData(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public StudentData[] searchData(String toSearch) {
        // TODO Auto-generated method stub
        StudentData data[] = new StudentData[10];
        return data;
    }

    @Override
    public void showData() {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean editData(String name) {
        // TODO Auto-generated method stub
        return false;
    }

}
