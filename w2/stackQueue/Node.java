package stackQueue;

public class Node<Item> {
    public Node<Item> next;
    public Node<Item> prev;
    public Item val;

    public Node(Item v, Node<Item> n, Node<Item> p) {
        val = v;
        next = n;
        prev = p;
    }

    public Node(Item v) {
        val = v;
        next = null;
        prev = null;
    }

}
