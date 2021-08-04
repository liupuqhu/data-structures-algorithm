package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/3 9:23 下午
 **/
public class NC145_01Package {

    public static void main(String[] args) {
        int V = 10;
        int n = 2;
        int[][] vw = new int[2][2];
        vw[0] = new int[]{1, 3};
        vw[1] = new int[]{10, 4};

        NC145_01Package demo = new NC145_01Package();
        int result = demo.knapsack2(V, n, vw);
        System.out.println(result);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     *
     * @param V  int整型 背包的体积
     * @param n  int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack(int V, int n, int[][] vw) {
        // write code here
        int[][] dp = new int[n + 1][V + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if (j < vw[i - 1][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - vw[i - 1][0]] + vw[i - 1][1]);
                }
            }
        }

        return dp[n][V];
    }

    public int knapsack2(int V, int n, int[][] vw) {
        // write code here
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= 1; j--) {
                if (j >= vw[i - 1][0])
                    dp[j] = Math.max(dp[j], dp[j - vw[i - 1][0]] + vw[i - 1][1]);
            }
        }

        return dp[V];
    }

}
