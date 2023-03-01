import edu.princeton.cs.algs4.Stack;

public class Exercise49 {
    class StackQueue<T> {
        private int capacity = 0; 
        Stack stack1 = new Stack<>();
        Stack stack2 = new Stack<>();
        
        void push(T item) {
            capacity ++;
            stack1.push(item);
        }

        T pop() {
            capacity --;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return (T)stack2.pop();
        }


    }
}
