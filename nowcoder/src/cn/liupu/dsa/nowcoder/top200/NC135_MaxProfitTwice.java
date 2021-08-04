package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/3 9:52 下午
 **/
public class NC135_MaxProfitTwice {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9};
        NC135_MaxProfitTwice demo = new NC135_MaxProfitTwice();
        int result = demo.maxProfit(prices);
        System.out.println(result);
    }

    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int[][] dp = new int[prices.length][5];
        /**
         * i 天的下标
         * j 改天交易状态的下标   0:不交易, 1:第一次买入, 2:第一次卖出, 3:第二次买入, 4:第二次卖出
         * dp[i][j] 第i天交易状态为j时的最大收益。
         */

        //初始化数据
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }

        return dp[prices.length - 1][4];
    }
}
