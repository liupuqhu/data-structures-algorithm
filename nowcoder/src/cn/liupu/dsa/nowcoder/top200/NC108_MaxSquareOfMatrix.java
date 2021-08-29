package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/29 2:58 下午
 **/
public class NC108_MaxSquareOfMatrix {

    public static void main(String[] args) {

        NC108_MaxSquareOfMatrix demo = new NC108_MaxSquareOfMatrix();

        char[][] matrix = new char[4][4];
        matrix[0] = new char[]{'1', '0', '1', '0', '0'};
        matrix[1] = new char[]{'1', '0', '1', '1', '1'};
        matrix[2] = new char[]{'1', '1', '1', '1', '1'};
        matrix[3] = new char[]{'1', '0', '0', '1', '0'};

        System.out.println(demo.solve(matrix));
    }

    public int solve(char[][] matrix) {
        // write code here
        int maxSide = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(maxSide,dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

}
