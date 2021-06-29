package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/28 4:08 下午
 **/
public class NC17_GetLongestPalindrome {

    public static void main(String[] args) {

        String str = "312abcba898";
        NC17_GetLongestPalindrome demo = new NC17_GetLongestPalindrome();

        System.out.println(demo.getLongestPalindrome(str, str.length()));

    }

    public int getLongestPalindrome(String A, int n) {
        if (n < 2) {
            return n;
        }

        int maxLen = 0;

        for (int i = 0; i < n; ) {
            if (n - i < maxLen) break;

            int left = i;
            int right = i;

            while (right < n - 1 && A.charAt(right) == A.charAt(right + 1)) {
                right++;
            }

            i = right + 1;

            while (left > 0 && right < n - 1 && A.charAt(left - 1) == A.charAt(right + 1)) {
                left--;
                right++;
            }
            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
            }
        }

        return maxLen;
    }
}

