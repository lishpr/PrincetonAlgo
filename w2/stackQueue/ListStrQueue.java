package stackQueue;

import java.util.Iterator;

public class ListStrQueue<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> head;
    private Node<Item> tail;

    public ListStrQueue() {
        size = 0;
    }

    public void enqueue(Item item) {
        Node<Item> a = new Node<Item>(item);
        if (size == 0) {
            head = a;
        } else {
            tail.next = a;
            a.prev = tail;
        }
        tail = a;
        size++;
    }

    public Item deque() {
        if (size == 0) return null;
        Node<Item> a = head;
        if (size > 1) {
            head = head.next;
            head.prev = null;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        size--;
        return a.val;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        Node<Item> curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + "]");
            curr = curr.next;
        }
        System.out.println();
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> curr = head;
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item item = curr.val;
            curr = curr.next;
            return item;
        }

    }

    public static void main(String[] args) {
        ListStrQueue<String> q = new ListStrQueue<>();
        int i = 0;
        char a = 'A';
        while (i < 20) {
            q.enqueue(Character.toString(a));
            q.printQueue();
            i++;
        }
        while (q.size() > 0) {
            q.deque();
            q.printQueue();
        }
    }
}
