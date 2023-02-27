import java.util.Iterator;

public class ArrayStack<T> implements Iterable {

    private T[] a = (T[]) new Object[1];
    private int n = 0;

    public void push(T item) {
        if (n == a.length)
            resize(a.length * 2);
        a[n++] = item;
    }

    public T pop() {
        T item = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4)
            resize(a.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void resize(int max) {
        T[] temp = (T[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator {
        int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Object next() {
            return a[--i];
        }

    }

}