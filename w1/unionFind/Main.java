package unionFind;

public class Main {

    public static void main(String[] args) {
        UF uf = new QuickUnion(10);

        uf.union(1, 2);
        System.out.println(uf.find(1, 2));
        System.out.println(uf.find(1, 3));
    }
}
