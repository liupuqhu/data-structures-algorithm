package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/29 4:10 下午
 **/
public class NC152_DivideNumber {

    public static void main(String[] args) {

        NC152_DivideNumber demo = new NC152_DivideNumber();

        int i = demo.divideNumber(734, 22);
        System.out.println(i);

    }


    public int divideNumber(int n, int k) {
        // write code here
        int[][] dp = new int[n + 1][k + 1];

        int mode = 1_000_000_000 + 7;

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - j][j]) % mode;
            }
        }
        return dp[n][k];
    }
}
