import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

/**
 * @author Nicholas
 * @version 1.0
 */
public class RandomBag<T> implements Iterable {

    private T[] array;
    private int n = 0;
    private int index = 0;
    private static final int CAPACITY = 5;

    public RandomBag() {
        array = (T[])new Object[CAPACITY];
    }

    public void resizingArray(int capacity) {
        T[] newArray = (T[])new Object[capacity];
        System.arraycopy(array, 0,newArray, 0, n);
        array = newArray;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        array[index++] = item;
        n++;
        if (n > array.length / 2) {
            resizingArray(array.length * 2);
        }
    }

    @Override
    public Iterator iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator {

        T[] tmpArray;
        int tmp = 0;

        public BagIterator() {
            tmpArray = (T[])new Object[n];
            System.arraycopy(array, 0, tmpArray, 0, n);
            for (int i = 0; i < n; i++) {
                int tmp = i + StdRandom.uniform(n - i);
                T item = tmpArray[tmp];
                tmpArray[tmp] = tmpArray[i];
                tmpArray[i] = item;
            }
        }

        @Override
        public boolean hasNext() {
            return tmp != n;
        }

        @Override
        public Object next() {
            T item = tmpArray[tmp];
            tmp++;
            return item;
        }
    }
}
