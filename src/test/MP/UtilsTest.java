package MP;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UtilsTest {

    @Test
    public void testIsEqual() {

        StudentData student1 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData student2 = new StudentData("Leonhard Euler", 1, 1, "Earth");

        StudentData student3 = new StudentData("Isaac Newton", 2, 2, "Mars");

        assertTrue(Utils.isEqual(student1, student2));
        assertFalse(Utils.isEqual(student1, student3));

    }

    @Test
    public void testKeywordInEntries() {
        StudentData student1 = new StudentData("Leonhard Euler", 1, 1, "Earth");

        assertTrue(Utils.keywordInEntries(student1, "Euler"));
        assertFalse(Utils.keywordInEntries(student1, "Gauss"));
    }
}
