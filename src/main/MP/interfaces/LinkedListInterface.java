package MP.interfaces;

public interface LinkedListInterface<T> {

    /**
     * Adds the element at the end of the list.
     *
     * @param element the element to be added to the end of the list
     */
    void append(T element);


    /**
     * Deletes the element given by its index from the list.
     *
     * @param index the index of the element to be deleted.
     */
    void delete(int index);


    /**
     * Finds the index of the element that is passed on to it. Throws an error if
     * the element is not in the list.
     *
     * @param element the object of type T that you want to get the index of.
     * @return the index of the element
     */
    int find(T element);

    /**
     * Returns the data of a node at the index. This is similar to indexing an array using the []
     * notation.
     *
     * @param index the index of the data you want to get.
     * @return the data of type T you indexed.
     */
    T get(int index);
}
