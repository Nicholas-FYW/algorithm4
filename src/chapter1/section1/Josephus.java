package src.chapter1.section1;

/**
 * @author Nicholas
 * @version 1.0
 */
public class Josephus {

    public static void solution(int n, int m) {
        LinkListQueue<Integer> queue = new LinkListQueue();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                queue.enqueue(queue.dequeue());
                i++;
            }
            System.out.print(queue.dequeue() + "\t");
        }
    }

    public static void main(String[] args) {
        solution(7, 2);
    }
}
