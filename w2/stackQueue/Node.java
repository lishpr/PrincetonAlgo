package stackQueue;

public class Node {
    public Node next;
    public Node prev;
    public String val;

    public Node(String v, Node n, Node p) {
        val = v;
        next = n;
        prev = p;
    }

    public Node(String v) {
        val = v;
        next = null;
        prev = null;
    }

}
