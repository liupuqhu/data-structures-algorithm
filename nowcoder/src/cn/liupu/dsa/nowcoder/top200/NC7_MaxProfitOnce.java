package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/3 9:52 下午
 **/
public class NC7_MaxProfitOnce {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 9, 6, 9, 1, 7, 1, 1, 5, 9, 9, 9};
        NC7_MaxProfitOnce demo = new NC7_MaxProfitOnce();
        int result = demo.maxProfit(prices);
        System.out.println(result);
    }

    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit(int[] prices) {
        // write code here
        int maxProfit = 0;
        int dp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (dp < 0) {
                dp = prices[i] - prices[i - 1];
            } else {
                dp = dp + prices[i] - prices[i - 1];
            }
            if (dp > maxProfit) {
                maxProfit = dp;
            }
        }

        return maxProfit;
    }
}
