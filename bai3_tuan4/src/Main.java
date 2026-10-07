import java.util.Arrays;


public class Main {
    public static void insertionSort (int[] a, int n){
        int temp = a[n-1];
        int j = n-2;
        boolean ok = false;
        while (j >= 0 && !ok) {
            if (a[j] > temp) {
                a[j+1] = a[j];
                j--;
                printArray(a);
            } else {
                ok = true;
            }
        }
        a[j+1] = temp;
        printArray(a);
    }

    public static void printArray (int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] arr = {5, 11, 13, 14, 15, 7};
        int n = arr.length;

        long start = System.currentTimeMillis();

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        insertionSort(arr, n);

        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));

        long end = System.currentTimeMillis();

        System.out.println("thoi gian chay la:" + (end-start));
    }
}