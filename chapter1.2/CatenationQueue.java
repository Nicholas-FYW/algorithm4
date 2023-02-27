/**
 * Created by Nicholas on 2022/12/28 17:15.
 */
public class CatenationQueue{

    public static LinkListQueue catenation(LinkListQueue queue1, LinkListQueue queue2) {
        LinkListQueue newQueue = new LinkListQueue();
        while (!queue1.isEmpty()) {
            newQueue.enqueue(queue1.dequeue());
        }
        while (!queue2.isEmpty()) {
            newQueue.enqueue(queue2.dequeue());
        }
        return newQueue;
    }
}
