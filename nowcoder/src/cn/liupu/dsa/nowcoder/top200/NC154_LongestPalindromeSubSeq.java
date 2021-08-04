package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/4 12:47 上午
 **/
public class NC154_LongestPalindromeSubSeq {

    public static void main(String[] args) {

        NC154_LongestPalindromeSubSeq demo = new NC154_LongestPalindromeSubSeq();

        int result = demo.longestPalindromeSubSeq("ddadccd");
        System.out.println(result);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string 一个字符串由小写字母构成，长度小于5000
     * @return int
     */
    public int longestPalindromeSubSeq(String s) {
        // write code here

        int len = s.length();

        if (len == 0) {
            return 0;
        }

        int[][] num = new int[len][len];

        for (int i = 0; i < num.length; i++) {
            num[i][i] = 1;
        }

        for (int i = 0; i < num.length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                num[i][i + 1] = 2;
            } else {
                num[i][i + 1] = 1;
            }
        }

        for (int length = 3; length <= num.length; length++) {
            for (int i = 0; i <= num.length - length; i++) {
                if (s.charAt(i) == s.charAt(i + length - 1)) {
                    num[i][i + length - 1] = num[i + 1][i + length - 2] + 2;
                } else {
                    num[i][i + length - 1] = Math.max(num[i][i + length - 2], num[i + 1][i + length - 1]);
                }
            }
        }

        return num[0][len - 1];
    }
}
