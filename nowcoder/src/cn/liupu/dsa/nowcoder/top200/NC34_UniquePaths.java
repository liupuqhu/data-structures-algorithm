package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/29 2:39 下午
 **/
public class NC34_UniquePaths {


    public static void main(String[] args) {

        NC34_UniquePaths demo = new NC34_UniquePaths();

        int i = demo.uniquePaths(2, 3);
        System.out.println(i);

    }


    public int uniquePaths(int m, int n) {
        // write code here
        int[][] dp = new int[m][n];

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
