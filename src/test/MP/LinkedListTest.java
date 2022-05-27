package MP;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import MP.linkedList.LinkedList;

public class LinkedListTest {
    @Test
    public void testAppend() {

        StudentData s0 = new StudentData("Leonhard Euler", 1, 1, "Earth");
        StudentData s1 = new StudentData("Leonhard Euler", 1, 1, "Earth");

        LinkedList<StudentData> list = new LinkedList<StudentData>();
        list.append(s0);
        list.append(s1);

        assertEquals(s0, list.get(0));
        assertEquals(s1, list.get(1));

    }

    @Test
    public void testDelete() {
        StudentData s0 = new StudentData("person 1", 1, 1, "Earth");
        StudentData s1 = new StudentData("person 2", 2, 2, "Mars");
        StudentData s2 = new StudentData("person 3", 3, 3, "Jupiter");

        LinkedList<StudentData> list = new LinkedList<StudentData>();

        list.append(s0);
        list.append(s1);
        list.append(s2);

        list.delete(1);

        assertEquals(s2, list.get(1));
    }

    @Test
    public void testFind() {
        StudentData s0 = new StudentData("person 1", 1, 1, "Earth");
        StudentData s1 = new StudentData("person 2", 2, 2, "Mars");
        StudentData s2 = new StudentData("person 3", 3, 3, "Jupiter");

        LinkedList<StudentData> list = new LinkedList<StudentData>();

        list.append(s0);
        list.append(s1);
        list.append(s2);

        assertEquals(0, list.find(s0));

        assertEquals(1, list.find(s1));
        assertEquals(2, list.find(s2));

    }

    @Test
    public void testGetNode() {
        LinkedList<StudentData> list = new LinkedList<StudentData>();

        StudentData s0 = new StudentData("Arnold Euler", 1, 1, "Earth");
        StudentData s1 = new StudentData("Leonhard Euler", 2, 2, "Mars");
        StudentData s2 = new StudentData("Isaac Newton", 3, 3, "Jupiter");
        StudentData s3 = new StudentData("Albert Einstein", 4, 4, "Jupiter");

        list.append(s0);
        list.append(s1);
        list.append(s2);
        list.append(s3);

        assertEquals(s0, list.get(0));
        assertEquals(s1, list.get(1));
        assertEquals(s2, list.get(2));
        assertEquals(s3, list.get(3));

    }

}
