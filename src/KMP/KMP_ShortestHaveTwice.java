package KMP;

public class KMP_ShortestHaveTwice {
    public static String solution(String str) {
        if (str == null || str.length() == 0) return null;
        if (str.length() == 1) return str.concat(str);
        int index = getNextArray(str)[str.length()];
        return str.concat(str.substring(index));
    }

    private static int[] getNextArray(String str) {
        int[] nextArray = new int[str.length() + 1];
        char[] chars = str.toCharArray();
        nextArray[0] = -1;
        nextArray[1] = 0;
        /*******************************************************/
        int pos = 2;
        int preNext = 0;
        while (pos < nextArray.length) {
            if (chars[pos - 1] == chars[preNext]) {
                nextArray[pos] = preNext + 1;
                ++preNext;
                ++pos;

            } else if (preNext > 0) {
                /*******************************************************/
                preNext = nextArray[preNext];
                /*******************************************************/
            }else{
                nextArray[pos] = 0;
                preNext = 0;
                ++pos;
            }
        }
        /*******************************************************/
        return nextArray;
    }


    public static void main(String[] args) {
        String test1 = "a";
        System.out.println(solution(test1));
        String test2 = "abcdefabc";
        System.out.println(solution(test2));
        String test3 = "ababcababmkaba";
        System.out.println(solution(test3));
    }
}
