package permutation;

import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private class MyRQIterator implements Iterator<Item> {
        private int i;
        int[] ord;
        public MyRQIterator() {
            i = 0;
            ord = new int[size];
            for (int i = 0; i < size; i++) {
                ord[i] = i;
            }
            StdRandom.shuffle(ord);
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            return arr[ord[i++]];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private int size;
    private Item[] arr;

    // construct an empty randomized queue
    public RandomizedQueue() {
        arr = (Item[]) new Object[16];
        size = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (size >= arr.length) {
            Item[] temp = (Item[]) new Object[arr.length * 2];
            System.arraycopy(arr, 0, temp, 0, arr.length);
            arr = temp;
        }
        arr[size] = item;
        size++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new java.util.NoSuchElementException();
        int i = StdRandom.uniform(size);
        Item a = arr[i];
        arr[i] = arr[size - 1];
        size--;
        return a;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) throw new java.util.NoSuchElementException();
        return arr[StdRandom.uniform(size)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new MyRQIterator();
    }

    private void printRQ() {
        for (int i = 0; i < size; i++) {
            System.out.printf("[%d]", arr[i]);
        }
        System.out.println();
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        for (int i = 0; i < 20; i++) {
            rq.enqueue(i);
        }
        rq.printRQ();
        int i = 0;
        while (i < 5) {
            System.out.printf("%d, ",rq.sample());
            i++;
        }
        System.out.println();
        for (Integer j : rq) {
            System.out.printf("[%d]", j);
        }
        System.out.println();
        while (!rq.isEmpty()) {
            rq.dequeue();
            rq.printRQ();
        }
    }

}