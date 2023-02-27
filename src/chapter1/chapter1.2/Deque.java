import java.util.Iterator;

/**
 * @author Nicholas
 * @version 1.0
 */
public class Deque<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size;

    public Deque() {}

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        return size;
    }

    void pushLeft(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
        size++;
    }

    void pushRight(T item) {
        Node node = new Node(item);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    T popLeft() {
        T item = (T)head.item;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head.next.pre = null;
            head = head.next;
        }
        size--;
        return item;
    }

    T popRight() {
        T item = (T)tail.item;
        if(tail == head) {
            head = null;
            tail = null;
        } else {
            tail.pre.next = null;
            tail = tail.pre;
        }
        size--;
        return item;
    }

    private class Node<T> {
        Node pre;
        Node next;
        T item;

        public Node(T item) {
            this.item = item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeIteror();
    }

    private class DequeIteror implements Iterator{
        Node index = head;
        @Override
        public boolean hasNext() {
            return index != null;
        }

        @Override
        public Object next() {
            T item = (T)index.item;
            index = index.next;
            return item;
        }
    }
}
