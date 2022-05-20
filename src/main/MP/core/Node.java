package MP.core;

public class Node<T> {
    protected T data;
    public Node<T> next;

    public Node(T _data) {
        data = _data;
        next = null;
    }
}
