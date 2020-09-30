package percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private int side;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        grid = new int[n + 1][n + 1];
        uf = new WeightedQuickUnionUF(n * n + 2);
        side = n;
    }

    private int translate(int row, int col) {
        return (row - 1) * side + (col - 1);
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row > side || row < 1 || col > side || col < 1) {
            throw new IllegalArgumentException();
        }
        if (isOpen(row, col)) return;
        grid[row][col] = 1;
        if (row == 1) {
            uf.union(translate(row, col), side * side);
        }
        if (row == side) {
            uf.union(translate(row, col), side * side + 1);
        }
        if (isOpen(row - 1, col, true)) {
            uf.union(translate(row - 1, col), translate(row, col));
        }
        if (isOpen(row + 1, col, true)) {
            uf.union(translate(row + 1, col), translate(row, col));
        }
        if (isOpen(row, col - 1, true)) {
            uf.union(translate(row, col - 1), translate(row, col));
        }
        if (isOpen(row, col + 1, true)) {
            uf.union(translate(row, col + 1), translate(row, col));
        }
    }

    private boolean isOpen(int row, int col, boolean check) {
        if (check && (row > side || row < 1 || col > side || col < 1)) {
            return false;
        }
        return grid[row][col] != 0;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row > side || row < 1 || col > side || col < 1) {
            throw new IllegalArgumentException();
        }
        return grid[row][col] != 0;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row > side || row < 1 || col > side || col < 1) {
            throw new IllegalArgumentException();
        }
        if (isOpen(row, col)) {
            return uf.find(translate(row, col)) == uf.find(side * side);
        }
        else return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        int count = 0;
        for (int i = 1; i <= side; i++) {
            for (int j = 1; j <= side; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(side * side + 1) == uf.find(side * side);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation p = new Percolation(3);
        p.open(1, 1);
        StdOut.print(p.isOpen(1, 1) + "\n");
        StdOut.print(p.isFull(1, 1) + "\n");
        StdOut.print(p.percolates() + "\n");
        p.open(2, 1);
        StdOut.print(p.isOpen(1, 1) + "\n");
        StdOut.print(p.isFull(1, 1) + "\n");
        StdOut.print(p.percolates() + "\n");
    }
}
