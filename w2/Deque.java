package permutation;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private static class Node<Item> {
        public Node<Item> next;
        public Node<Item> prev;
        public Item val;

        public Node(Item v) {
            val = v;
            next = null;
            prev = null;
        }
    }

    private class MyDequeIterator implements Iterator<Item> {
        private Node<Item> curr = head;
        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            if (curr == null) throw new java.util.NoSuchElementException();
            Item item = curr.val;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node<Item> head;
    private Node<Item> tail;
    private int size;

    // construct an empty deque
    public Deque() {
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> a = new Node<>(item);
        if (size == 0) {
            tail = a;
        } else {
            a.next = head;
            head.prev = a;
        }
        head = a;
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        Node<Item> a = new Node<>(item);
        if (size == 0) {
            head = a;
        } else {
            tail.next = a;
            a.prev = tail;
        }
        tail = a;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        Node<Item> a = head;
        if (size == 0) throw new java.util.NoSuchElementException();
        if (size > 1) {
            head.next.prev = null;
            head = head.next;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        size--;
        return a.val;
    }

    // remove and return the item from the back
    public Item removeLast() {
        Node<Item> a = tail;
        if (size == 0) throw new java.util.NoSuchElementException();
        if (size > 1) {
            tail.prev.next = null;
            tail = tail.prev;
        }
        if (size == 1) {
            head = null;
            tail = null;
        }
        size--;
        return a.val;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new MyDequeIterator();
    }

    private void printQueue() {
        Node<Item> curr = head;
        while (curr != null) {
            System.out.print("[" + curr.val + "]");
            curr = curr.next;
        }
        System.out.println();
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> q = new Deque<>();
        for (int i = 0; i < 20; i++) {
            q.addLast(i);
            q.addFirst(40 - i);
        }
        while (q.size() > 10) {
            q.removeFirst();
        }
        q.printQueue();
        while (!q.isEmpty()) {
            q.removeLast();
        }
    }

}