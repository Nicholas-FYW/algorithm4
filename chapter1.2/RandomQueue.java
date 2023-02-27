import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author Nicholas
 * @version 1.0
 */
public class RandomQueue<T> implements Iterable {

    private T[] array;
    private int n = 0;
    private static final int CAPACITY = 5;

    public RandomQueue() {
        array = (T[]) new Object[CAPACITY];
    }

    public void resizingArray(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, n);
        array = newArray;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enQueue(T item) {
        array[n++] = item;
        if (n > array.length / 2) {
            resizingArray(array.length * 2);
        }
    }

    public T deQueue() {
        if(isEmpty()) {
            throw new RuntimeException("array is null");
        }
        int index = StdRandom.uniform(n);
        T val = array[index];
        array[index] = array[n - 1];
        array[n - 1] = null;
        n--;
        if (n > 0 && n == array.length / 4) {
            resizingArray(array.length / 2);
        }
        return val;
    }

    public T sample() {
        int index = StdRandom.uniform(n);
        return array[index];
    }

    @Override
    public Iterator iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator {
        T[] tmpArray = (T[])new Object[n];
        int size = 0;

        public QueueIterator() {
            System.arraycopy(array, 0, tmpArray, 0, n);
            for (int i = 0; i < n; i++) {
                int index = StdRandom.uniform(n - i);
                T val = array[index];
                array[index] = array[i];
                array[i] = val;
            }
        }

        @Override
        public boolean hasNext() {
            return size != n;
        }

        @Override
        public Object next() {
            T item = array[size];
            size++;
            return item;
        }
    }
}
