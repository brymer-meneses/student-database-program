package MP.core;

import java.io.Serializable;

import MP.interfaces.LinkedListInterface;

public class LinkedList<T> implements LinkedListInterface<T>, Serializable {
    protected Node<T> head;
    protected Node<T> tail;
    public int length = 0;

    @Override
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

        length += 1;
    }

    @Override
    public void delete(int index) {

        // if index is the end of the list
        if (index == length) {
            Node<T> nodeBeforeTail = getNode(index - 1);
            tail = nodeBeforeTail;
            tail.next = null;
            length -= 1;
            return;
        }

        // if index is at the beginning of the list
        if (index == 0) {
            Node<T> nodeAfterHead = getNode(index + 1);
            head = nodeAfterHead;
            length -= 1;
            return;
        }

        // if index is at the middle of the list
        Node<T> nodeBeforeNodeAtIndex = getNode(index - 1);
        nodeBeforeNodeAtIndex.next = nodeBeforeNodeAtIndex.next.next;
        length -= 1;
    }

    @Override
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

    @Override
    public T get(int index) {
        return getNode(index).data;

    }

    private Node<T> getNode(int index) {

        if (index > length || index < 0) {
            throw new java.lang.Error(
                    String.format("Element cannot be found. Expected integer in range of [0, %d). Got: %d ", length,
                            index));
        }

        Node<T> rover = head;

        for (int i = 0; i < index; i++) {
            rover = rover.next;
        }

        return rover;
    }

}
