/**
 * @author Nicholas
 * @version 1.0
 */
public class Steque<T> {
    private Node head;
    private Node tail;

    public void push(T item) {
        Node node = new Node(item);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public T pop() {
        T item = (T)head.item;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return item;
    }

    public void enqueue(T item) {
        Node node = new Node(item);
        if(tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private class Node<T> {
        Node next;
        T item;

        public Node(T item) {
            this.item = item;
        }
    }
}
