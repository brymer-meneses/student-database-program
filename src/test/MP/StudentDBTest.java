package MP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDBTest {
    @Test
    public void testAdd() {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("person 1", 1, 1, "Earth"));
        sdb.addData(new StudentData("person 2", 2, 2, "Earth"));
        sdb.addData(new StudentData("person 3", 3, 3, "Earth"));

        assertEquals(sdb.head.name, "person 1");
        assertEquals(sdb.tail.name, "person 3");

        assertEquals(sdb.head.next.name, "person 2");

    }

}
