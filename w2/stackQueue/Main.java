package stackQueue;
import edu.princeton.cs.algs4.Stopwatch;

public class Main {
    public static void main(String[] args) {
        String a = "A";
        Stopwatch s1 = new Stopwatch();
        StackOfStrings s = new ListStrStack();
        for (int i = 0; i < 1000000; i++) {
            s.push(a);
        }
        while (!s.isEmpty()) {
            s.pop();
        }
        System.out.println(s1.elapsedTime());

        String b = "A";
        Stopwatch s2 = new Stopwatch();
        StackOfStrings t = new ArrayStrStack();
        for (int i = 0; i < 1000000; i++) {
            t.push(b);
        }
        while (!s.isEmpty()) {
            t.pop();
        }
        System.out.println(s2.elapsedTime());

    }
}
