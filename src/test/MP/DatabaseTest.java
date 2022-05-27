package MP;

import org.junit.jupiter.api.Test;

import MP.linkedList.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {


    @Test
    public void testDatabaseWrite()  {
        Database sdb = new Database();

        sdb.append(new StudentData("Leonhard Euler", 2, 2, "Mars"));
        sdb.append(new StudentData("Isaac Newton", 3, 3, "Jupiter"));
        sdb.append(new StudentData("Albert Einstein", 4, 4, "Jupiter"));

        sdb.delete(0);
        sdb.writeChangesToFile();

        Database retrievedSdb = Database.readSavedFile();

        assertEquals(sdb.length, retrievedSdb.length);
        assertEquals(sdb.get(0).name, retrievedSdb.get(0).name);
        assertEquals(sdb.get(1).name, retrievedSdb.get(1).name);
    }

    @Test
    public void testGetLatestData() {
        Database sourceSdb = new Database();

        sourceSdb.append(new StudentData("Leonhard Euler", 2, 2, "Mars"));
        sourceSdb.append(new StudentData("Isaac Newton", 3, 3, "Jupiter"));
        sourceSdb.append(new StudentData("Albert Einstein", 4, 4, "Jupiter"));

        sourceSdb.writeChangesToFile();

        Database emptySdb = new Database();
        Database latestSdb = Database.readSavedFile();

        assertNotEquals(emptySdb.length, latestSdb.length);

        emptySdb = Database.readSavedFile();

        assertEquals(emptySdb.length, latestSdb.length);
        assertEquals(emptySdb.get(0).name, latestSdb.get(0).name);
        assertEquals(emptySdb.get(1).name, latestSdb.get(1).name);
    }
}
