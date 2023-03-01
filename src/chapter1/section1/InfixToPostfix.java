package src.chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 分情况进行考虑：
 *    分别考虑扫描操作符、操作数、括号的情况
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        LinkListStack<String> opts = new LinkListStack();
        String ans = "";
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+") || s.equals("-")) {
                while (!opts.isEmpty()) {
                    String opt = opts.pop();
                    if (opt.equals("(")) {
                        opts.push(opt);
                        break;
                    }
                    ans += opt;
                }
                opts.push(s);
            } else if (s.equals("*") || s.equals("/")) {
                while (!opts.isEmpty()) {
                    String opt = opts.pop();
                    if (opt.equals("*") || opt.equals("/")) {
                        ans += opt;
                    } else {
                        opts.push(opt);
                        break;
                    }
                }
                opts.push(s);
            } else if (s.equals(")")) {
                String opt = opts.pop();
                while (!opt.equals("(")) {
                    ans += opt;
                    opt = opts.pop();
                }
            } else if (s.equals("(")) {
                opts.push(s);
            } else {
                ans += s;
            }
        }
        while (!opts.isEmpty()) {
            ans += opts.pop();
        }
        StdOut.println(ans);
    }

}
