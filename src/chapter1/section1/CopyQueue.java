package src.chapter1.section1;

/**
 * Created by Nicholas on 2022/12/2 22:25.
 */
public class CopyQueue<T> extends LinkListQueue<T> {

    public CopyQueue(LinkListQueue queue) {
        for (Object item : queue) {
            enqueue((T) item);
        }
    }
}
