package collinerPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> res;
    private Point[] copy;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        ArrayList<Point> ans = new ArrayList<>(Arrays.asList(points));
        if (ans.contains(null)) throw new IllegalArgumentException();
        copy = points.clone();
        Arrays.sort(copy);
        if (hasDuplicate(copy)) throw new IllegalArgumentException();

        res = new ArrayList<>();
        int N = copy.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (check(copy[i], copy[j], copy[k], copy[l])) {
                            res.add(new LineSegment(copy[i], copy[l]));
                        }
                    }
                }
            }
        }

    }

    private boolean hasDuplicate(Point[] copy) {
        for (int i = 0; i < copy.length - 1; i++)
            if (copy[i].compareTo(copy[i + 1]) == 0) return true;
        return false;
    }

    private boolean check(Point p, Point q, Point r, Point s) {
        return p.slopeTo(q) == q.slopeTo(r) && q.slopeTo(r) == r.slopeTo(s);
    }

    public int numberOfSegments() {
        return res.size();
    }

    public LineSegment[] segments() {
        return this.res.toArray(new LineSegment[0]);
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
        }
    }
}
