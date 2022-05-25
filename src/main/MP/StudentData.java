package MP;

import java.io.Serializable;

public class StudentData implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    public String name;
    public int saisId;
    public int studentNumber;
    public  String address;

    public StudentData next;

    public StudentData(String name, int saisId, int studentNumber, String address) {
        this.name = name;
        this.saisId = saisId;
        this.studentNumber = studentNumber;
        this.address = address;

        this.next = null;
    }

    public boolean isEqualTo(StudentData other) {

        if (name.equals(other.name) && saisId == other.saisId)
            return true;

        return false;
    }

    public boolean keywordInEntries(String keyword) {
        if (name.contains(keyword))
            return true;

        if (address.contains(keyword))
            return true;

        if (Integer.toString(saisId).contains(keyword))
            return true;

        if (Integer.toString(studentNumber).contains(keyword))
            return true;

        return false;

    }

}
