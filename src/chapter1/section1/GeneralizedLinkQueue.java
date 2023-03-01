package src.chapter1.section1;

/**
 * @author Nicholas
 * @version 1.0
 */
public class GeneralizedLinkQueue<T> {
    private Node head = null;
    private Node tail = null;
    private int n = 0;

    private class Node {
        Node next;
        T item;

        public Node(T item) {
            this.item = item;
        }
    }

    public GeneralizedLinkQueue() {
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
             tail.next = node;
             tail = node;
        }
        n++;
    }

    public T delete(int k) {
        Node tmp = head;
        T item = null;
        Node node = head;
        if (k == 1) {
            item = head.item;
            head = head.next;
        } else if (k == n) {
            item = tail.item;
            while (node.next != tail) {
                node = node.next;
            }
            tail = node;
        } else {
            for (int i = 1; i < k - 1; i++) {
                node = node.next;
            }
            item = node.next.item;
            node.next = node.next.next;
        }
        return item;
    }
}
