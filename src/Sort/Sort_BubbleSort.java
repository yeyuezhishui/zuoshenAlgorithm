package Sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class Sort_BubbleSort {
    private static void BubbleSort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int j = ints.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (ints[i] > ints[i + 1]) {
                    swap(ints, i, i + 1);
                }
            }
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
        BubbleSort(test1);
        System.out.println(Arrays.toString(test1));
        BubbleSort(test2);
        System.out.println(Arrays.toString(test2));
        };
}
