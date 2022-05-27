package MP.linkedList;

import java.io.Serializable;

/**
 * A custom implementation of the Node data structure that is used in our
 * implementation of the Linked List Data structure.
 * @param <T>
 */
public class Node<T> implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    protected T data;
    protected Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
