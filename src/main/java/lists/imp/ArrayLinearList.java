package lists.imp;

import lists.LinearList;

public class ArrayLinearList<T> implements LinearList<T> {
    // fields
    private int size;
    private T[] elements;

    // constructors
    @SuppressWarnings("unchecked")
    public ArrayLinearList(int initialCapacity) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException("index must be higher that zero");
        elements = (T[]) new Object[initialCapacity];
        size = 0;
    }

    public ArrayLinearList() {
        this(10);
    }

    // methods
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return elements[index];
    }

    public int indexOf(T theElement) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(theElement))
                return i;
        }
        return -1;
    }

    public T remove(int index) {
        checkIndex(index);
        T elementRemoved = elements[index];
        size--;
        for (int i = index; i < size; i++)
            elements[i] = elements[i + 1];

        return elementRemoved;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, T theElement) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index must not be < 0 or >= size");
        if (size == elements.length) {
            T[] old = elements;
            elements = (T[]) new Object[2 * size];
            System.arraycopy(old, 0, elements, 0, size);
        }

        for (int i = index + 1; i < size; i++)
            elements[i] = elements[i - 1];

        elements[index] = theElement;
        size++;
    }

    public void add(T theElement) {
        add(0, theElement);
    }

    @Override
    public String toString() {
        StringBuilder os = new StringBuilder();
        os.append("[");
        if (!isEmpty())
            os.append(' ').append(elements[0]);
        for (int i = 1; i < size; i++)
            os.append(", ").append(elements[i]);
        os.append(" ]");
        return os.toString();
    }

     // utilities
    private void checkIndex(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index must not be < 0 or > size");
    }
}
