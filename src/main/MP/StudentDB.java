package MP;

public class StudentDB implements DBInterface {

    public StudentData head;
    public StudentData tail;

    @Override
    public boolean addData(StudentData dbd) {
        if (hasDuplicateEntriesWithDatabase(dbd))
            return false;

        if (head == null) {
            head = dbd;
        } else {
            tail = head;

            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = dbd;
            tail = dbd;
        }
        return true;

    }

    @Override
    public boolean deleteData(String name, int SAISID) {
        StudentData rover = head;

        while (rover != null) {
            if (rover.next.name == name && rover.next.saisID == SAISID) {
                rover.next = rover.next.next;
                return true;
            }
            rover = rover.next;
        }

        return false;
    }

    @Override
    public StudentData[] searchData(String toSearch) {
        StudentData data[] = new StudentData[10];

        StudentData rover = head;

        int index = 0;

        while (rover != null) {
            if (rover.keywordInEntries(toSearch)) {
                data[index] = rover;
                index++;
            }
            rover = rover.next;
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

    public boolean hasDuplicateEntriesWithDatabase(StudentData other) {

        StudentData rover = head;

        while (rover != null) {
            if (rover.hasSameEntries(other)) {
                return true;
            }
            rover = rover.next;
        }
        return false;
    }

}
