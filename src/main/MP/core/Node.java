package MP.core;

public class Node<T> {
    protected T data;
    protected Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
