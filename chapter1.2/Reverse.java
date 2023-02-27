public class Reverse<T> {

    private static class Node<T> {

        T item;
        Node next;

        public Node(T item) {
            this.item = item;
        }
    }

    public static Node ReverseLinkList01(Node first) {
        Node node = null;
        while (first != null) {
            Node ans = new Node(first.item);
            ans.next = node;
            node = ans;
            first = first.next;
        }
        return node;
    }

    public static Node ReverseLinkList02(Node node) {
        Node first = node;
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }

    //翻转链表的递归方法
    public static Node ReverseLinkList03(Node node) {
        if (node == null) return null;
        if (node.next == null) return node;
        Node rest = ReverseLinkList03(node.next);
        Node temp = rest;
        while(rest.next != null) {
            rest = rest.next;
        }
        node.next = null;
        rest.next = node;
        return temp;  
    }

    //递归翻转链表书中方法
    public static Node ReverseLinkList04(Node first) {
        if (first == null) return null;
        if (first.next == null) return first;
        Node second = first.next;
        Node rest = ReverseLinkList04(second);
        first.next = null;
        second.next = first;
        return rest;
    }

    public static void main(String[] args) {
        Node<Integer> node = new Node(1);
        Node<Integer> node1 = new Node(2);
        Node<Integer> node2 = new Node(3);
        Node<Integer> node3 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        Node n = ReverseLinkList04(node);
        while (n != null) {
            System.out.println(n.item);
            n = n.next;
        }

    }

}
