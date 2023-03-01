package src.chapter1.section1;

/**
 * @author Nicholas
 * @version 1.0
 */
public class GeneralizedQueue<T> {

    private T[] array = null;
    private int n = 0;

    public GeneralizedQueue() {
        array = (T[]) new Object[1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T item) {
        if (n == array.length) {
            resize(array.length * 2);
        }
        array[n] = item;
        n++;
    }

    public T delete(int k) {
        if (isEmpty()) {
            throw new RuntimeException("array is null");
        }
        if (k < 0 || n < k) {
            throw new RuntimeException("invalid index");
        }
        T item = array[k - 1];
        moveitemLeft(k);
        n--;
        if (n == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public void moveitemLeft(int index) {
        for (int i = index; i < n; i++) {
            array[i - 1] = array[i];
        }
        array[n - 1] = null;
    }

    public void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
