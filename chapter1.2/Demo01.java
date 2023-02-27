import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Demo01 {

    public static void main(String[] args) {
        LinkListStack<String> vals = new LinkListStack<>();
        LinkListStack<String> opts = new LinkListStack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                opts.push(s);
            } else if (s.equals(")")) {
                String valleft, valright;
                valright = vals.pop();
                valleft = vals.pop();
                String temp = "(" + valleft + opts.pop() + valright + ")";
                vals.push(temp);
            } else {
                vals.push(s);
            }
        }
        System.out.println("1");
        StdOut.println(vals.pop());
    }

}
