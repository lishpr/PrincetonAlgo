package priorityQueue;

public class MaxPQ<Key extends Comparable<Key>> {

    private int N;
    private Key[] arr;
    public MaxPQ(){
        arr = (Key[]) new Comparable[16];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private void sift(int i) {
        while (i > 1 && less(i / 2, i)) {
            exch(i, i / 2);
            i /= 2;
        }
    }

    public void insert(Key k) {
        arr[++N] = k;
        sift(N);
    }

    private boolean less(int a, int b) {
        return arr[a].compareTo(arr[b]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}