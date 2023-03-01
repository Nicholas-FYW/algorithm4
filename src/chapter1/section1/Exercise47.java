package src.chapter1.section1;

import edu.princeton.cs.algs4.Stack;

public class Exercise47 {
    Stack catenation(Stack q1, Stack q2) {
        Stack stack = new Stack();
        while (!q1.isEmpty()) {
            stack.push(q1.pop());
        }
        while (!q2.isEmpty()) {
            stack.push(q2.pop());
        }
        return stack; 
    }
}