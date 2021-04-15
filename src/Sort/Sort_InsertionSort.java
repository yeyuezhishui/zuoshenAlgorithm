package Sort;

import java.util.Arrays;

/**
 * @author yexiangyu
 * @create 2021-04-15-19:41
 */
public class Sort_InsertionSort {
    private static void insertionSort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j >= 0; j--) {
                if (ints[j - 1] < ints[j]) {
                    continue;
                }
                swap(ints, j, j - 1);
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
        insertionSort(test1);
        System.out.println(Arrays.toString(test1));
        insertionSort(test2);
        System.out.println(Arrays.toString(test2));
    }
}
