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
    public void testMaxEntriesInDatabase() {
        StudentDB sdb = new StudentDB();

        String[] names = { "Euler", "Gauss", "Riemann", "Cardoano", "Cauchy", "Newton", "Leibniz", "Fourier",
                "Galois", "L'hopital", "Tao" };

        for (int i = 0; i < 8; i++) {
            sdb.addData(new StudentData(names[i], i, i, names[i]));
        }

        assertEquals(8, sdb.length);
        assertEquals(true, sdb.addData(new StudentData(names[8], 8, 8, names[8])));
        assertEquals(true, sdb.addData(new StudentData(names[9], 9, 9, names[9])));

        assertEquals(10, sdb.length);
        assertEquals(false, sdb.addData(new StudentData(names[10], 10, 10, names[10])));
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

        assertEquals("person 1", sdb.head.name);
        assertEquals("person 3", sdb.tail.name);

        assertEquals("person 2", sdb.head.next.name);

    }

    @Test
    public void testDelete() {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("person 1", 1, 1, "Earth"));
        sdb.addData(new StudentData("person 2", 2, 2, "Mars"));
        sdb.addData(new StudentData("person 3", 3, 3, "Jupiter"));
        sdb.addData(new StudentData("person 4", 4, 4, "Jupiter"));

        sdb.deleteData("person 2", 2);

        assertEquals("person 3", sdb.head.next.name);

        sdb.deleteData("person 3", 3);

        assertEquals("person 4", sdb.head.next.name);

    }

    @Test
    public void testSearch() {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("Arnold Euler", 1, 1, "Earth"));
        sdb.addData(new StudentData("Leonhard Euler", 2, 2, "Mars"));
        sdb.addData(new StudentData("Isaac Newton", 3, 3, "Jupiter"));
        sdb.addData(new StudentData("Albert Einstein", 4, 4, "Jupiter"));

        StudentData results[] = sdb.searchData("Euler");

        assertEquals(true, results[0].name.contains("Euler"));
        assertEquals(true, results[1].name.contains("Euler"));

        assertEquals(false, results[0].name.contains("Newton"));
        assertEquals(false, results[0].name.contains("Einstein"));

    }

}
