/**
 * Created by Nicholas on 2022/12/26 12:50.
 */
public class Buffer {

    private LinkListStack<Character> left;
    private LinkListStack<Character> right;

    public Buffer() {
        left = new LinkListStack<Character>();
        right = new LinkListStack<Character>();
    }

    public void insert(char c) {
        right.push(c);
    }

    public char delete() {
        return right.pop();
    }

    public void left(int k) {
        for (int i = 0; i < k && left.size() > 0; i++) {
            right.push(left.pop());
        }
    }

    public void rigth(int k) {
        for (int i = 0; i < k && right.size() > 0; i++) {
            left.push(right.pop());
        }
    }

    public int size() {
        return left.size() + right.size();
    }

}
