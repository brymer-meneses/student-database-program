package MP;

import java.io.Serializable;

/**
 * A datatype that contains the Name, SAIS number, Student Number and Student Provincial Address
 * of a student in the database.
 *
 * Notice that this class needs to implement the Serializable interface since it needs to be
 * saved and read through a file.
 */
public class StudentData implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    public String name;
    public int saisId;
    public int studentNumber;
    public String address;

    public StudentData next;

    public StudentData(String name, int saisId, int studentNumber, String address) {
        this.name = name;
        this.saisId = saisId;
        this.studentNumber = studentNumber;
        this.address = address;

        this.next = null;
    }
}
