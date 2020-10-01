package stackQueue;

public class ListStrStack implements StackOfStrings {
    private Node head;
    private Node tail;
    private int size;

    public ListStrStack() {
        size = 0;
    }

    public void push(String s) {
        Node a = new Node(s);
        if (size == 0) {
            head = a;
        } else {
            tail.next = a;
            a.prev = tail;
        }
        tail = a;
        size++;
    }

    public void printStack() {
        Node curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + "]");
            curr = curr.next;
        }
        System.out.println();
    }

    public String pop() {
        if (size == 0) return null;
        String a = tail.val;
        if (size > 1) {
            tail.prev.next = null;
            tail = tail.prev;
        }
        size--;
        return a;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        else return false;
    }

    public int size() {
        return size;
    }

}
