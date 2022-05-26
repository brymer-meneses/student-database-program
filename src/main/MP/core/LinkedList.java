package MP.core;

import java.io.Serializable;

import MP.interfaces.LinkedListInterface;

/**
 * This class is our own custom implementation of the Linked List data structure.
 * We used the concept of Generics to ensure that it can be used for other data types
 * as well.
 *
 * This is data structure is heavily used on the MP.StudentDB methods and is also used in the
 * frontend.
 *
 * Notice that this class implements the Serializable since we leverage this class in order for
 * the database to save at the file.
 * @param <T>
 */
public class LinkedList<T> implements LinkedListInterface<T>, Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    protected Node<T> head;
    protected Node<T> tail;
    public int length = 0;

    /**
     * Adds the element at the end of the list.
     *
     * @param element the element to be added to the end of the list
     */
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

    /**
     * Deletes the given index from the list.
     *
     * @param index the index of the element to be deleted.
     */
    @Override
    public void delete(int index) {

        // if index is the end of the list
        if (index == length) {
            tail = getNode(index - 1);
            tail.next = null;
            length -= 1;
            return;
        }

        // if index is at the beginning of the list
        if (index == 0) {
            head = getNode(index + 1);
            length -= 1;
            return;
        }

        // if index is at the middle of the list
        Node<T> nodeBeforeNodeAtIndex = getNode(index - 1);
        nodeBeforeNodeAtIndex.next = nodeBeforeNodeAtIndex.next.next;
        length -= 1;
    }


    /**
     * Finds the index of the element that is passed on to it. Throws an error if
     * the element is not in the list.
     *
     * @param element the object of type T that you want to get the index of.
     * @return the index of the element
     */
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

    /**
     * Returns the data of a node at the index. This is similar to indexing an array using the []
     * notation.
     *
     * @param index the index of the data you want to get.
     * @return the data of type T you indexed.
     */
    @Override
    public T get(int index) {
        return getNode(index).data;

    }

    /**
     * Similar to `get()` but returns the Node data type, this is used internally to avoid
     * code duplications.
     *
     * @param index the index of the data you want to get
     * @return the Node of type T you indexed.
     */

    private Node<T> getNode(int index) {

        if (index >= length || index < 0) {
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
