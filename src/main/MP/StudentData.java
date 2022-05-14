package MP;

public class StudentData {
    final String name;
    final int saisID;
    final int studentNumber;
    final String address;

    public StudentData next;

    public StudentData(String name, int saisID, int studentNumber, String address) {
        this.name = name;
        this.saisID = saisID;
        this.studentNumber = studentNumber;
        this.address = address;

        this.next = null;
    }

    public boolean hasSameEntries(StudentData other) {

        if (name.equals(other.name) && saisID == other.saisID)
            return true;

        return false;
    }

}
