package MP.core;

public class Node<T> {
    protected T data;
    public Node<T> next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
