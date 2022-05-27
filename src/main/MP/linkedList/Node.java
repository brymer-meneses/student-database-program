package MP.linkedList;

import java.io.Serializable;

public class Node<T> implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    protected T data;
    protected Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
