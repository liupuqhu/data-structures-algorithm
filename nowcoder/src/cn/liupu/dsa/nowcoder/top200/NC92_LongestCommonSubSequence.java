package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 10:28 下午
 **/
public class NC92_LongestCommonSubSequence {

    public static void main(String[] args) {

        NC92_LongestCommonSubSequence demo = new NC92_LongestCommonSubSequence();

        String str1 = "1A2C3D4B56";
        String str2 = "B1D23A456A";

        System.out.println(demo.LCS(str1, str2));

    }

    public String LCS(String s1, String s2) {

        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return "-1";
        }

        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            int j = 1;
            for (; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        if (dp[len1][len2] == 0) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        int i = len1;
        int j = len2;

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1]) {
                i--;
                j--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            }
        }

        return sb.reverse().toString();
    }

}
