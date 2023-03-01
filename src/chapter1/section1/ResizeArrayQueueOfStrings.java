package src.chapter1.section1;

import java.util.Iterator;

public class ResizeArrayQueueOfStrings implements Iterable {

    private String[] array;
    private int first = 0;
    private int last = 0;

    public ResizeArrayQueueOfStrings(int cap) {
        array = new String[cap];
    }

    public void enqueue(String item) {
        if (size() == array.length - 1) {
            System.out.println("Array is Full");
            return;
        }
        array[last] = item;
        last = (last + 1) % array.length;
    }
    public String dequeue() {
        if (isEmpty()) {
            return "Array Is Already Empty";
        }
        String item = array[first];
        first = (first + 1) % array.length;
        return item;
    }

    public int size() {
        return (last + array.length - first) % array.length;
    }

    public boolean isEmpty() {
        return first == last;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator {
        int temp = first;

        @Override
        public boolean hasNext() {
            return temp != last;
        }

        @Override
        public Object next() {
            String item = array[temp];
            temp = (temp + 1) % array.length;
            return item;
        }

    }

    public static void main(String[] args) {
        ResizeArrayQueueOfStrings queue = new ResizeArrayQueueOfStrings(6);
        System.out.println(queue.dequeue());
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        for (Object item : queue) {
            System.out.println(item);
        }
        queue.enqueue("4");
        queue.enqueue("5");
        queue.enqueue("6");
        for (Object item : queue) {
            System.out.println(item);
        }
        queue.enqueue("7");

    }

}
