package Sort;

import java.util.Arrays;

public class Sort_MergeSort_SmallSum {
    private static int smallSum(int[] ints, int L, int R) {
        if (ints == null || L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return smallSum(ints, L, mid) + smallSum(ints, mid + 1, R) + merge(ints, L, R);
    }

    private static int merge(int[] ints, int L, int R) {
        int mid = L + ((R - L) >> 1);
        int[] tempInts = new int[R - L + 1];
        int i = L, j = mid + 1, k = 0;
        int sum = 0;
        while (i <= mid && j <= R) {
            if (ints[i] < ints[j]) {
                sum += ints[i] * (R - j + 1);
            }
            /* 稳定排序版本：
             * tempInts[k++] = ints[i] <= ints[j] ? ints[i++] : ints[j++];
             * 就错了，都写成不稳定的小于
             * */
            tempInts[k++] = ints[i] < ints[j] ? ints[i++] : ints[j++];
        }
        while (i <= mid) {
            tempInts[k++] = ints[i++];
        }
        while (j <= R) {
            tempInts[k++] = ints[j++];
        }
        for (int t = 0; t < tempInts.length; t++) {
            ints[L + t] = tempInts[t];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{12, 3, 6, 43, 2, 1, 87, 3, 22, 3};
        int[] test2 = new int[]{1};

        System.out.println(smallSum(test1, 0, test1.length - 1));
        System.out.println(smallSum(test2, 0, test2.length - 1));
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
    }
}
