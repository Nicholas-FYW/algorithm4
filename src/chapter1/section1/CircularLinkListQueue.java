package src.chapter1.section1;

public class CircularLinkListQueue<T> {
    private Node tail = null;
    private int n = 0;

    private class Node<T> {

        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public void enqueue(T item) {
        Node node = new Node(item);
        if (isEmpty()) {
            node.next = node;
        } else {
            node.next = tail.next;
            tail.next = node;
        }
        tail = node;
        n++;
    }

    public T dequeue() {
        T item = (T) tail.item;
        if (tail.next == tail) {
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        n--;
        return item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return tail == null;
    }

}
