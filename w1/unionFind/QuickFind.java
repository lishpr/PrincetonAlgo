package unionFind;

public class QuickFind implements UF {
    private int[] nodes;

    public QuickFind(int k) {
        nodes = new int[k];
        for (int i = 0; i < k; i++) {
            nodes[i] = i;
        }
    }

    public boolean find(int i, int j) {
        if (nodes[i] == nodes[j]) {
            return true;
        } else {
            return false;
        }
    }

    public void union(int m, int n) {
        int mMarker = nodes[m];
        int nMarker = nodes[n];
        if (mMarker == nMarker) return;
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == mMarker) {
                nodes[i] = nMarker;
            }
        }
    }
}
