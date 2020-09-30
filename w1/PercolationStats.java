package percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private int side;
    private Percolation p;
    private int t;
    private double[] data;
    private double[] avg;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        side = n;
        t = trials;
        data = new double[trials];
        avg = new double[trials];
        for (int i = 0; i < trials; i++) {
            p = new Percolation(n);
            data[i] = tries();
            avg[i] = data[i] / (side * side);
        }
    }

    private double tries() {
        double count = 0;
        while (!p.percolates()) {
            int x = StdRandom.uniform(side) + 1;
            int y = StdRandom.uniform(side) + 1;
            if (!p.isOpen(x, y)) {
                p.open(x, y);
                count++;
            }
        }
        return count;
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(avg);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(avg);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(t);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(t);
    }

    // test client (see below)
    public static void main(String[] args) {

        PercolationStats ps = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

        StdOut.printf("mean = %f\n", ps.mean());
        StdOut.printf("stddev = %f\n", ps.stddev());
        StdOut.printf("95 %% confidence interval = [%f, %f]\n", ps.confidenceLo(), ps.confidenceHi());

    }

}