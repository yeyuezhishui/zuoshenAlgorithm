package Sort;

import java.util.Arrays;

public class Sort_SelectionSort {
    private static void selectionSort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            int minIndex = i;
            for (int j = i; j < ints.length; j++) {
                minIndex = (ints[j] < ints[minIndex] ? j : minIndex);
            }
            swap(ints,i,minIndex);
        }
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{12, 3, 6, 43, 2, 1, 87, 3, 22, 3};
        int[] test2 = new int[]{1};
        selectionSort(test1);
        System.out.println(Arrays.toString(test1));
        selectionSort(test2);
        System.out.println(Arrays.toString(test2));
    }
}
