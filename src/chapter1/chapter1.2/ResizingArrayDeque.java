import java.util.Iterator;

/**
 * @author Nicholas
 * @version 1.0
 */
public class ResizingArrayDeque<T> implements Iterable{
    private T[] array;
    private int n = 0;
    private int head;
    private static final int CAPACITY = 5;

    public ResizingArrayDeque() {
        array = (T[]) new Object[CAPACITY];
        head = CAPACITY / 2;
    }

    public void resizeArray(int capacity) {
        int startPosition = (capacity / 2) - (n / 2);
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, head + 1, newArray, startPosition, n);
        head = startPosition - 1;
        array = newArray;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(T item) {
        array[head--] = item;
        n++;
        if (head < 0) {
            if (n > array.length / 2) {
                resizeArray(array.length * 2);
            } else {
                resizeArray(array.length);
            }
        }
    }

    public void pushRight(T item) {
        int endIndex = head + n + 1;
        array[endIndex] = item;
        n++;
        if (endIndex == array.length - 1) {
            if (n > array.length / 2) {
                resizeArray(array.length * 2);
            } else {
                resizeArray(array.length);
            }
        }
    }

    public T popLeft() {
        if (isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        T item = array[++head];
        array[head] = null;
        n--;
        if (n == array.length / 4) {
            resizeArray(array.length / 2);
        }
        return item;
    }

    public T popRight() {
        if(isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        int endIndex = head + n;
        T item = array[endIndex];
        n--;
        if (n == array.length / 4) {
            resizeArray(array.length / 2);
        }
        return item;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator {
        int index = head + 1;

        @Override
        public boolean hasNext() {
            return index != head + n + 1;
        }

        @Override
        public Object next() {
            T item = array[index];
            index++;
            return item;
        }
    }
}
