import java.util.Iterator;

public class LinkListBag<T> implements Iterable{

    private Node first = null;
    private int n = 0;

    private class Node<T> {
        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public void add(T item) {
        Node oldfirst = first;
        first = new Node(item);
        first.next = oldfirst;
        n++;
    }

    public int size() {
        return n;
    }
    
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator iterator() {
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator {

        private Node<T> temp = first;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public Object next() {
            T item = temp.item;
            temp = temp.next; 
            return item;
        }

    }
    
}
