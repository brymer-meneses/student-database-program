package MP.interfaces;

public interface LinkedListInterface<T> {

    abstract void append(T element);

    abstract void delete(int index);

    abstract int find(T element);

    abstract T get(int index);
}
