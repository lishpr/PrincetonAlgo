package unionFind;

public class QuickUnion implements UF {
    private int[] nodes;
    private int[] sizes;

    public QuickUnion(int k) {
        nodes = new int[k];
        sizes = new int[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int m, int n) {
        int i = rooting(m);
        int j = rooting(n);
        if (i == j) return;
        if (sizes[i] < sizes[j]) {
            nodes[i] = j;
            sizes[j] += sizes[i];
        } else {
            nodes[j] = i;
            sizes[i] += sizes[j];
        }
    }


    public boolean find(int i, int j) {
        if (rooting(i) == rooting(j)) return true;
        else return false;
    }

    private int rooting(int n) {
        int temp = n;
        while (nodes[temp] != temp) {
            nodes[temp] = nodes[nodes[temp]];
            temp = nodes[temp];
        }
        return temp;
    }
}