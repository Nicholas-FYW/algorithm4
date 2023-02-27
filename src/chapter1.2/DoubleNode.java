/**
 * @author fang
 */
public class DoubleNode<T> {
    private Node head = null;
    private Node tail = null;

    public void addHeadNode(T item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }

    public void addTailNode(T item) {
        Node node = new Node(item);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.pre = tail;
            node.next = null;
            tail.next = node;
            tail = node;
        }
    }

    public T delHeadNode() {
        T item = (T)head.item;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head.next.pre = null;
            head = head.next;
        }
        return item;
    }

    public T delTailNode() {
        T item = (T)tail.item;
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            tail.pre.next = null;
            tail = tail.pre;
        }
        return item;
    }

    public void addBeforeNode(T item) {
        Node node = head;
        while(node.item != item)
        {
            node = node.next;
        }
        if(node == head) {
            addHeadNode(item);
        } else {
            Node tmp = new Node(item);
            tmp.next = node;
            tmp.pre = node.pre;
            node.pre.next = tmp;
            node.pre = tmp;
        }
    }

    public void addAfterNode(T item) {
        Node node = head;
        while(node.item != item) {
            node = node.next;
        }
        if(node == tail) {
            addTailNode(item);
        } else {
            addBeforeNode((T) node.next.item);
        }
    }

    public boolean delNode(T item) {
        Node node = head;
        while(node.item != item) {
            node = node.next;
            if(node == null) {
                return false;
            }
        }
        if(node == head) {
            delHeadNode();
        } else if(node == tail) {
            delTailNode();
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return true;
    }

    public static void main(String[] args) {

    }

    private class Node<T> {
        T item;
        Node pre;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

}
