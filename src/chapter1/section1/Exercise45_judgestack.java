package src.chapter1.section1;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Exercise45_judgestack {
    boolean judgestack(Queue<Character> instr, Queue<Character> outstr) {
        Stack stack = new Stack();
        int len = instr.size();
        for (int i = 0; i < len; i ++) {
            char c = instr.dequeue();
            stack.push(c);
            while (!stack.isEmpty() && stack.peek() == outstr.peek()) {
                stack.pop();
                outstr.dequeue();
            }     
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
