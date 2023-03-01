package src.chapter1.section1;

import java.util.Iterator;

public class LinkListQueue<T> implements Iterable{

    private Node first = null;
    private Node last = null;
    private int n = 0;

    private class Node<T> {

        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public void enqueue(T item) {
        Node oldlast = last;
        last= new Node(item);
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        n++;
    }

    public T dequeue() {
        T item = (T) first.item;
        first = first.next;
        if(isEmpty()) {
            last = first;
        }
        n--;
        return item;
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

    private class LinkListIterator implements Iterator{

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