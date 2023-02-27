/**
 * Created by Nicholas on 2022/12/3 15:22.
 */
public class CopyStack<T> extends LinkListStack<T> {

    public CopyStack(LinkListStack<T> stack) {
        LinkListStack<T> tmp = new LinkListStack();
        for (Object item : stack) {
            tmp.push((T) item);
        }
        for (Object item : tmp) {
            push((T) item);
        }
    }
}
