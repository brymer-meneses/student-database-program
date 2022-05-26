package MP;

import org.junit.jupiter.api.Test;

import MP.core.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;;

import java.io.FileNotFoundException;

public class StudentDBTest {

    @Test
    public void testDuplicate() {

        StudentData student1 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student2 = new StudentData("Leonhard Euler", 1, 1, "Earth");

        assertEquals(true, student1.isEqualTo(student2));

    }

    @Test
    public void testMaxEntriesInDatabase() {
        StudentDB sdb = new StudentDB();

        String[] names = { "Euler", "Gauss", "Riemann", "Cardoano", "Cauchy", "Newton", "Leibniz", "Fourier",
                "Galois", "L'hopital", "Tao" };

        for (int i = 0; i < 8; i++) {
            sdb.addData(new StudentData(names[i], i, i, names[i]));
        }

        assertEquals(8, sdb.length());
        assertEquals(true, sdb.addData(new StudentData(names[8], 8, 8, names[8])));
        assertEquals(true, sdb.addData(new StudentData(names[9], 9, 9, names[9])));

        assertEquals(10, sdb.length());
        assertEquals(false, sdb.addData(new StudentData(names[10], 10, 10, names[10])));
    }

    @Test
    public void testDuplicateEntries() {

        StudentDB sdb = new StudentDB();

        StudentData student1 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student2 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student3 = new StudentData("Isaac Newton", 1, 7, "Earth");

        sdb.addData(student1);

        assertEquals(true, sdb.isDuplicateOfDatabase(student2));
        assertEquals(false, sdb.isDuplicateOfDatabase(student3));

    }

    @Test
    public void testAddData() {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("person 1", 1, 1, "Earth"));
        sdb.addData(new StudentData("person 2", 2, 2, "Mars"));
        sdb.addData(new StudentData("person 3", 3, 3, "Jupiter"));

        assertEquals("person 1", sdb.getData(0).name);
        assertEquals("person 2", sdb.getData(1).name);
        assertEquals("person 3", sdb.getData(2).name);

    }

    @Test
    public void testDeleteData() {
        StudentDB sdb = new StudentDB();

        StudentData s0 = new StudentData("Arnold Euler", 1, 1, "Earth");
        StudentData s1 = new StudentData("Leonhard Euler", 2, 2, "Mars");
        StudentData s2 = new StudentData("Isaac Newton", 3, 3, "Jupiter");
        StudentData s3 = new StudentData("Albert Einstein", 4, 4, "Jupiter");

        sdb.addData(s0);
        sdb.addData(s1);
        sdb.addData(s2);
        sdb.addData(s3);

        assertEquals(s0, sdb.getData(0));
        assertEquals(s1, sdb.getData(1));
        assertEquals(s2, sdb.getData(2));
        assertEquals(s3, sdb.getData(3));

        sdb.deleteData(s0.name, s0.saisId);
        sdb.deleteData(s1.name, s1.saisId);
        sdb.deleteData(s2.name, s2.saisId);

        assertEquals(s3, sdb.getData(0));

    }

    @Test
    public void testSearchData() {
        StudentDB sdb = new StudentDB();

        StudentData s0 = new StudentData("Albert Einstein", 4, 4, "Jupiter");
        StudentData s1 = new StudentData("Arnold Euler", 1, 1, "Earth");
        StudentData s2 = new StudentData("Leonhard Euler", 2, 2, "Mars");
        StudentData s3 = new StudentData("Isaac Newton", 3, 3, "Jupiter");

        sdb.addData(s0);
        sdb.addData(s1);
        sdb.addData(s2);
        sdb.addData(s3);
        LinkedList<StudentData> results;

        results = sdb.searchData("Earth");

        assertEquals(s1, results.get(0));
        assertEquals(1, results.length);

        results = sdb.searchData("Einstein");

        assertEquals(s0, results.get(0));
        assertEquals(1, results.length);

        results = sdb.searchData("Jupiter");

        assertEquals(s0, results.get(0));
        assertEquals(s3, results.get(1));
        assertEquals(2, results.length);

    }

    @Test
    public void testSaveData() throws FileNotFoundException {
        StudentDB sdb = new StudentDB();

        StudentData s0 = new StudentData("Albert Einstein", 4, 4, "Jupiter");
        StudentData s1 = new StudentData("Arnold Euler", 1, 1, "Earth");
        StudentData s2 = new StudentData("Leonhard Euler", 2, 2, "Mars");
        StudentData s3 = new StudentData("Isaac Newton", 3, 3, "Jupiter");

        sdb.addData(s0);
        sdb.addData(s1);
        sdb.addData(s2);
        sdb.addData(s3);

        StudentDB retrievedSdb = StudentDB.readSavedData();

        assertEquals(sdb.getData(0).name, retrievedSdb.getData(0).name);
    }

    @Test
    public void testEditData() {
        StudentDB sdb = new StudentDB();

        StudentData s0 = new StudentData("Albert Einstein", 4, 4, "Jupiter");
        StudentData s1 = new StudentData("Arnold Euler", 1, 1, "Earth");
        StudentData s2 = new StudentData("Leonhard Euler", 2, 2, "Mars");
        StudentData s3 = new StudentData("Isaac Newton", 3, 3, "Jupiter");

        StudentData result = new StudentData("Alan Einstein", 69, 69, "Saturn" );

        sdb.addData(s0);
        sdb.addData(s1);
        sdb.addData(s2);
        sdb.addData(s3);

        sdb.setCurrentEdit("Alan Einstein", 69, 69, "Saturn");
        sdb.editData("Albert Einstein", 4);

        assertEquals(result.name, sdb.getData(0).name);
        assertEquals(result.address, sdb.getData(0).address);
        assertEquals(result.saisId, sdb.getData(0).saisId);
        assertEquals(result.studentNumber, sdb.getData(0).studentNumber);

        StudentData result1 = new StudentData("Gauss", 24, 24, "Saturn" );

        sdb.setCurrentEdit("Gauss", 24, 24, "Saturn");
        sdb.editData("Arnold Euler", 1);

        assertEquals(result1.name, sdb.getData(1).name);
        assertEquals(result1.address, sdb.getData(1).address);
        assertEquals(result1.saisId, sdb.getData(1).saisId);
        assertEquals(result1.studentNumber, sdb.getData(1).studentNumber);
    }

    @Test
    public void testAutomaticDatabaseUpdate() throws FileNotFoundException {
        StudentDB sdb = new StudentDB();

        sdb.addData(new StudentData("Leonhard Euler", 2, 2, "Mars"));
        sdb.addData(new StudentData("Isaac Newton", 3, 3, "Jupiter"));
        sdb.addData(new StudentData("Albert Einstein", 4, 4, "Jupiter"));

        sdb.deleteData("Leonhard Euler", 2);

        StudentDB retrievedSdb = StudentDB.readSavedData();

        assertEquals(sdb.length(), retrievedSdb.length());
        assertEquals(sdb.getData(0).name, retrievedSdb.getData(0).name);
        assertEquals(sdb.getData(1).name, retrievedSdb.getData(1).name);
    }

    @Test
    public void testGetLatestData() throws FileNotFoundException {
        StudentDB sourceSdb = new StudentDB();

        sourceSdb.addData(new StudentData("Leonhard Euler", 2, 2, "Mars"));
        sourceSdb.addData(new StudentData("Isaac Newton", 3, 3, "Jupiter"));
        sourceSdb.addData(new StudentData("Albert Einstein", 4, 4, "Jupiter"));

        StudentDB emptySdb = new StudentDB();
        StudentDB latestSdb = StudentDB.readSavedData();

        assertNotEquals(emptySdb.length(), latestSdb.length());

        emptySdb.getLatestData();

        assertEquals(emptySdb.length(), latestSdb.length());
        assertEquals(emptySdb.getData(0).name, latestSdb.getData(0).name);
        assertEquals(emptySdb.getData(1).name, latestSdb.getData(1).name);
    }
}
