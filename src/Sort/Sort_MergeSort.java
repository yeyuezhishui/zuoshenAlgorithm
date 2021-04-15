package Sort;

import java.util.Arrays;

/**
 * @author yexiangyu
 * @create 2021-04-15-19:54
 */
public class Sort_MergeSort {
    private static void mergeSort(int[] ints, int L, int R) {
        if (ints == null || ints.length < 2 || L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(ints, L, mid);
        mergeSort(ints, mid + 1, R);
        merge(ints, L, R);
    }

    private static void merge(int[] ints, int L, int R) {
        int mid = L + ((R - L) >> 1);
        int[] tempInts = new int[R - L + 1];
        int i = L, j = mid + 1, k = 0;
        while (i <= mid && j <= R) {
            tempInts[k++] = ints[i] < ints[j] ? ints[i++] : ints[j++];
        }
        while (i <= mid) {
            tempInts[k++] = ints[i++];
        }
        while (j <= R) {
            tempInts[k++] = ints[j++];
        }
        System.arraycopy(tempInts, 0, ints, L, tempInts.length);
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{12, 3, 6, 43, 2, 1, 87, 3, 22, 3};
        int[] test2 = new int[]{1};
        mergeSort(test1, 0, test1.length - 1);
        System.out.println(Arrays.toString(test1));
        mergeSort(test2, 0, test2.length - 1);
        System.out.println(Arrays.toString(test2));
    }
}
