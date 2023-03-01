package src.chapter1.section1;

/**
 * @author Nicholas
 * @version 1.0
 */
public class RingBuffer<T> {

    private T[] array = null;
    private int head = 0;
    private int tail = 0;
    private int n = 0;
    private static final int N = 10;

    public RingBuffer() {
        array = (T[])new Object[N];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enbuffer(T item) {
        if (n == 10) {
            throw new RuntimeException("wait");
        }
        array[tail] = item;
        tail = (tail + 1) % N;
        n++;
    }

    public T debuffer() {
        if (isEmpty()) {
            throw new RuntimeException("null buffer");
        }
        T item = array[head];
        head = (head + 1) % N;
        n--;
        return item;
    }

    
}
