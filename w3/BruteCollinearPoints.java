package collinerPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class BruteCollinearPoints {
    List<LineSegment> res;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        List<Point> ans = new ArrayList<>(Arrays.asList(points));
        if (ans.contains(null)) throw new IllegalArgumentException();
        Set<Point> checker = new HashSet<>(ans);
        if (checker.size() < ans.size()) throw new IllegalArgumentException();

        Arrays.sort(points);

        res = new ArrayList<>();
        int N = points.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (check(points[i], points[j], points[k], points[l])) {
                            res.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }

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
