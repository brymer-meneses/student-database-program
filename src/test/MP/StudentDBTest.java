package MP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDBTest {

    @Test
    public void testSameEntries() {

        StudentData student1 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student2 = new StudentData("Leonhard Euler", 1, 1, "Earth");

        assertEquals(true, student1.hasSameEntries(student2));

    }

    @Test
    public void testDuplicateEntries() {

        StudentDB sdb = new StudentDB();

        StudentData student1 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student2 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student3 = new StudentData("Isaac Newton", 1, 7, "Earth");

        sdb.addData(student1);

        assertEquals(true, sdb.hasDuplicateEntriesWithDatabase(student2));
        assertEquals(false, sdb.hasDuplicateEntriesWithDatabase(student3));

    }

    @Test
    public void testAdd() {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("person 1", 1, 1, "Earth"));
        sdb.addData(new StudentData("person 2", 2, 2, "Mars"));
        sdb.addData(new StudentData("person 3", 3, 3, "Jupiter"));

        assertEquals(sdb.head.name, "person 1");
        assertEquals(sdb.tail.name, "person 3");

        assertEquals(sdb.head.next.name, "person 2");

    }

    @Test
    public void testDelete() {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("person 1", 1, 1, "Earth"));
        sdb.addData(new StudentData("person 2", 2, 2, "Mars"));
        sdb.addData(new StudentData("person 3", 3, 3, "Jupiter"));
        sdb.addData(new StudentData("person 4", 4, 4, "Jupiter"));

        sdb.deleteData("person 2", 2);

        assertEquals(sdb.head.next.name, "person 3");

        sdb.deleteData("person 3", 3);

        assertEquals(sdb.head.next.name, "person 4");

    }

}
