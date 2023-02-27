import java.util.Stack;

/**
 * Created by Nicholas on 2022/12/28 14:13.
 */
public class StackGenerability {

    public static boolean stackUnderflow(String[] inputValues) {
        int itemCount = 0;
        for (String s : inputValues) {
            if (s.equals("-")) {
                itemCount--;
            } else {
                itemCount++;
            }
            if (itemCount < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean permutationGeneration(String[] permutation) {
        Stack<Integer> stack = new Stack();
        int current = 0;
        for (String s : permutation) {
            int value = Integer.parseInt(s);
            if (stack.isEmpty() || value > stack.peek()) {
                while (current < value) {
                    stack.push(current);
                    current++;
                }
            } else if (value == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}
