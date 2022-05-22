package MP;

import java.io.Serializable;

public class StudentData implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    public final String name;
    public final int saisID;
    public final int studentNumber;
    public final String address;

    public StudentData next;

    public StudentData(String name, int saisID, int studentNumber, String address) {
        this.name = name;
        this.saisID = saisID;
        this.studentNumber = studentNumber;
        this.address = address;

        this.next = null;
    }

    public boolean isEqualTo(StudentData other) {

        if (name.equals(other.name) && saisID == other.saisID)
            return true;

        return false;
    }

    public boolean keywordInEntries(String keyword) {
        if (name.contains(keyword))
            return true;

        if (address.contains(keyword))
            return true;

        if (Integer.toString(saisID).contains(keyword))
            return true;

        if (Integer.toString(studentNumber).contains(keyword))
            return true;

        return false;

    }

}
