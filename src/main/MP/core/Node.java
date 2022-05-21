package MP.core;

import java.io.Serializable;

public class Node<T> implements Serializable {
    protected T data;
    protected Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
