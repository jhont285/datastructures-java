package lists;

public interface LinearList<T> {
    boolean isEmpty();
    int size();
    int indexOf(T theElement);
    T get(int index);
    T remove(int index);
    void add(int index, T theElement);
    void add(T theElement);
    String toString();
}
