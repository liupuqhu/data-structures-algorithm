package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/26 9:38 下午
 **/
public class NC127_LongestCommonSubString {

    public static void main(String[] args) {

        NC127_LongestCommonSubString demo = new NC127_LongestCommonSubString();

        String str1 = "1AB2345CD";
        String str2 = "12345EF";

        System.out.println(demo.LCS(str1, str2));

    }

    public String LCS(String str1, String str2) {

        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            return "";
        }

        // write code here
        int maxLen = 0;
        int end = 0;

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            int j = 1;
            for (; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        end = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        int start = end + 1 - maxLen;

        return str1.substring(start, end + 1);
    }
}
