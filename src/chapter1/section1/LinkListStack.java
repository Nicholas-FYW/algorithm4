package src.chapter1.section1;

import java.util.Iterator;

public class LinkListStack<T> implements Iterable {

    private Node first = null;
    private int n = 0;

    private class Node<T> {

        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public void push(T item) {
        Node oldfirst = first;
        Node node = new Node(item);
        node.next = oldfirst;
        first = node;
        n++;
    }

    public T pop() {
        T item = (T) first.item;
        first = first.next;
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

    private class LinkListIterator implements Iterator {

        private Node<T> temp = first;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public T next() {
            T item = temp.item;
            temp = temp.next;
            return item;
        }
    }



}