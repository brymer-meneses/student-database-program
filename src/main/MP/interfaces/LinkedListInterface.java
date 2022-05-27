package MP.interfaces;

public interface LinkedListInterface<T> {

    void append(T element);

    void delete(int index);

    int find(T element);

    T get(int index);
}
