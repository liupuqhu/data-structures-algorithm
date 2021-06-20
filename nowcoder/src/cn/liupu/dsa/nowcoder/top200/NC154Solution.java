package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/4/19 10:20 下午
 **/
public class NC154Solution {


    public static void main(String[] args) {

        String s = "abccsb";
        int index = longestPalindromeSubSeq(s);
        System.out.println(index);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string 一个字符串由小写字母构成，长度小于5000
     * @return int
     */
    public static int longestPalindromeSubSeq(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        // i - j 的最长回文子序列的长度
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

}
