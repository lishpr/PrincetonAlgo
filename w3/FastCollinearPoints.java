package collinerPoints;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;


public class FastCollinearPoints {
    private Point[] copy;
    private ArrayList<LineSegment> res;
    public FastCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        ArrayList<Point> ans = new ArrayList<>(Arrays.asList(points));
        if (ans.contains(null)) throw new IllegalArgumentException();
        copy = points.clone();
        Arrays.sort(copy);
        if (hasDuplicate(copy)) throw new IllegalArgumentException();
        res = new ArrayList<>();
        int N = copy.length;
        ArrayList<Double> igSlope = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int j = 0;
            int k = 0;
            Point[] rest = points.clone();
            Arrays.sort(rest, copy[i].slopeOrder());
            double slope = copy[i].slopeTo(rest[j]);
            while (k < N) {
                double newSlope = copy[i].slopeTo(rest[k]);
                if (slope == newSlope) k++;
                else {
                    if (k - j >= 3 && !igSlope.contains(slope)) {
                        Point[] n = getFarthest(copy[i], Arrays.copyOfRange(rest, j, k));
                        LineSegment l = new LineSegment(n[0], n[n.length - 1]);
                        igSlope.add(slope);
                        res.add(l);
                    }
                    slope = newSlope;
                    j = k++;
                }
            }
        }
    }

    private boolean hasDuplicate(Point[] copy) {
        for (int i = 0; i < copy.length - 1; i++)
            if (copy[i].compareTo(copy[i + 1]) == 0) return true;
        return false;
    }

    private Point[] getFarthest(Point pivot, Point[] points) {
        Point[] n = Arrays.copyOf(points, points.length + 1);
        n[points.length] = pivot;
        Arrays.sort(n);
        return n;
    }

    public int numberOfSegments() {
        return res.size();
    }

    public LineSegment[] segments() {
        return res.toArray(new LineSegment[0]);
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
        }
    }
}