package elementarySorts;

public class ElementarySort {
    public static void selectionSort(Comparable[] a){
        int i = 0;
        int N = a.length;
        while (i < N) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
            i++;
        }
    }

    public static void insertionSort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                } else break;
            }
        }

    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(Comparable[] a) {
        for (Comparable comparable : a) {
            System.out.printf("[%d]", comparable);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] a = {2, 5, 3, 5, 1};
        printArray(a);
        insertionSort(a);
        printArray(a);
    }

}
