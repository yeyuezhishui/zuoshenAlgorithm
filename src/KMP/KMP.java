package KMP;

public class KMP {
    public static void main(String[] args) {
        String s = "bdabfabcabcdedef";
        String m = "abcabcd";
        int solution = findSubString(s, m);
        System.out.println("solution : " + solution);
    }

    public static int findSubString(String s, String m) {
        if (s == null || m == null || s.length() < m.length()) {
            return -1;
        }
        int si = 0, mi = 0;

        char[] sArray = s.toCharArray();
        char[] mArray = m.toCharArray();
        int[] nextArray = getNextArray(mArray);
        while (si <= s.length() && mi < m.length()) {
            if (sArray[si] == mArray[mi]) {
                ++si;
                ++mi;
            } else if (nextArray[mi] == -1) {
                ++si;
            } else {
                mi = nextArray[mi];
            }
        }
        return mi == m.length() ? si - mi : -1;
    }

    private static int[] getNextArray(char[] m) {
        int[] nextArray = new int[m.length];
        nextArray[0] = -1;
        nextArray[1] = 0;
        for (int i = 2; i < m.length; i++) {
            nextArray[i] = findNextNum(i, nextArray[i-1], m, nextArray);
        }
        return nextArray;
    }

    private static int findNextNum(int i, int j, char[] m, int[] nextArray) {
        if (m[i - 1] == m[j]) {
            return j + 1;
        } else if (j == 0) {
            return 0;
        } else {
            return findNextNum(i, nextArray[j] / 2, m, nextArray);
        }
    }
}
