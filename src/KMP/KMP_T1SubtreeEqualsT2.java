package KMP;

public class KMP_T1SubtreeEqualsT2 {
    public static boolean solution(Node t1, Node t2) {
        String s1 = serializeByPre(t1);
        String s2 = serializeByPre(t2);
        System.out.println(s1);
        System.out.println(s2);
        return KMP(s1, s2);
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static String serializeByPre(Node node) {
        if (node == null) {
            return "#!";
        } else {
            return node.value + "!" + serializeByPre(node.left) + serializeByPre(node.right);
        }
    }

    private static boolean KMP(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str1.length() < str2.length()) {
            return false;
        }
        if (str2.length() == 0) {
            return true;
        }
        char[] str1Char = str1.toCharArray();
        char[] str2Char = str2.toCharArray();
        int[] nextArray = getNextArray(str2);
        int i = 0, j = 0;
        while (i < str1Char.length && j < str2Char.length) {
            if (str1Char[i] == str2Char[j]) {
                i++;
                j++;
            } else if (nextArray[j] == -1) {
                i++;
            } else if (nextArray[j] == 0) {
                j = 0;
            } else {
                j = nextArray[j];
            }
        }
        return j == str2Char.length;
    }

    private static int[] getNextArray(String str) {
        int[] ints = new int[str.length()];
        if (str.length() == 1) {
            ints[0] = -1;
            return ints;
        }
        ints[0] = -1;
        ints[1] = 0;
        char[] strChar = str.toCharArray();
        int i = 2;
        int j = ints[1];
        while (i < ints.length) {
            if (strChar[i - 1] == strChar[j]) {
                ints[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = ints[j];
            } else {
                ints[i] = 0;
                i++;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(solution(t1, t2));
    }
}
