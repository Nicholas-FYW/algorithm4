import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfix {
    public static void main(String[] args) {
        LinkListStack<Double> vals = new LinkListStack<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")
                    || s.equals("-")
                    || s.equals("*")
                    || s.equals("/")) {
                double val = vals.pop();
                if (s.equals("+")) {
                    val = vals.pop() + val;
                } else if (s.equals("-")) {
                    val = vals.pop() - val;
                } else if (s.equals("*")) {
                    val = vals.pop() * val;
                } else if (s.equals("/")) {
                    val = vals.pop() / val;
                }
                vals.push(val);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }

}
