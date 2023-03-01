package src.chapter1.section1;

import java.util.Iterator;

public class Exercise48 {
    class DequeStack<T> {
        ResizingArrayDeque queue = new ResizingArrayDeque();
        int leftcap = 0;
        int rightcap = 0;
        void leftpush(T item) {
            queue.pushLeft(item);
            leftcap ++;
        }
        void rightpush(T item) {
            queue.pushRight(item);
            rightcap ++;
        }
        T leftpop() {
            if (leftcap == 0) {
                new RuntimeException("indexoutofbounds");
            }
            leftcap --;
            return (T)queue.popLeft();
        }
        T rightpop() {
            if (rightcap == 0) {
                new RuntimeException("indexoutofbounds");
            }
            rightcap --;
            return (T)queue.popRight();
        }
      
       
    }

    
}
