import java.util.HashSet;

/**
 * Created by Nicholas on 2022/12/2 21:02.
 */
public class MoveToFront<T> {
    private Node head;
    private HashSet<T> existingCharacter;
    private int n;

    public MoveToFront() {
        existingCharacter = new HashSet();
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T item) {
        if (existingCharacter.contains(item)) {
            delete(item);
        }
        Node oldHead = head;
        head = new Node(item);
        oldHead.next = head;
        n++;
    }

    public void delete(T item) {
        if (isEmpty()) {
           return;
        }
        Node tmp = head;
        if (item.equals(tmp.item)) {
            head = tmp.next;
            n--;
        } else {
            for (; tmp.next != null; tmp = tmp.next) {
                if (item.equals(tmp.next.item)) {
                    break;
                }
            }
            tmp.next = tmp.next.next;
            n--;
        }
    }


    private class Node {
        Node next;
        T item;

        public Node(T item) {
            this.item = item;
        }
    }
}
