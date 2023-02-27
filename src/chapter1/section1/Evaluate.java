import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Evaluate {
    public static void main(String[] args) {
        LinkListStack<Double> vals = new LinkListStack();
        LinkListStack<String> opts = new LinkListStack();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("("))
                ;
            else if (s.equals("+"))
                opts.push(s);
            else if (s.equals("-"))
                opts.push(s);
            else if (s.equals("*"))
                opts.push(s);
            else if (s.equals("/"))
                opts.push(s);
            else if (s.equals(")")) {
                String opt = opts.pop();
                Double val = vals.pop();
                if (opt.equals("+"))
                    val = vals.pop() + val;
                if (opt.equals("-"))
                    val = vals.pop() - val;
                if (opt.equals("*"))
                    val = vals.pop() * val;
                if (opt.equals("/"))
                    val = vals.pop() / val;
                vals.push(val);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }

}
