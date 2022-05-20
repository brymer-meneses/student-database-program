package MP.core;

public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int length = 0;

    public void append(T element) {

        Node<T> newElement = new Node<T>(element);

        if (head == null) {
            head = newElement;
            tail = newElement;
        } else {
            tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newElement;
            tail = newElement;
        }

        length++;
    }

    public void delete(int index) {
        Node<T> nodeBeforeIndex = getNode(index - 1);

        nodeBeforeIndex.next = nodeBeforeIndex.next.next;

    }

    public int find(T element) {

        Node<T> rover = head;

        for (int i = 0; i < length; i++) {
            if (rover.data.equals(element)) {
                return i;
            }
            rover = rover.next;

        }

        throw new java.lang.Error(
                String.format("Cannot find the index of such element. Perhaps it doesn't exist in the list?"));

    }

    public T get(int index) {
        return getNode(index).data;

    }

    private Node<T> getNode(int index) {

        if (index > length || index < 0) {
            throw new java.lang.Error(
                    String.format("Element cannot be found. Expected integer in range of [0, %d)", length));
        }

        Node<T> rover = head;

        for (int i = 0; i < index; i++) {
            rover = rover.next;
        }

        return rover;
    }

}
