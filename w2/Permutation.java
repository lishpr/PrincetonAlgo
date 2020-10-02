package permutation;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        RandomizedQueue<String> rq = new RandomizedQueue<>();

        String a = StdIn.readString();
        while (a.length() != 0) {
            rq.enqueue(a);
        }
        for (int i = 0; i < num; i++) {
            StdOut.println(rq.dequeue());
        }

    }
}