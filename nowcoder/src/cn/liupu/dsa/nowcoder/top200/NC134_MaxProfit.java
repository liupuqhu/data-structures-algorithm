package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/28 5:38 下午
 **/
public class NC134_MaxProfit {

    public static void main(String[] args) {

        NC134_MaxProfit demo = new NC134_MaxProfit();

        int[] prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(demo.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        // write code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
