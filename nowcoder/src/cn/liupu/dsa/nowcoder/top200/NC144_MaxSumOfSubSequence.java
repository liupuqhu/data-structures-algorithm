package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/29 3:43 下午
 **/
public class NC144_MaxSumOfSubSequence {

    public static void main(String[] args) {

        NC144_MaxSumOfSubSequence demo = new NC144_MaxSumOfSubSequence();

        int[] array = new int[]{-1};

        System.out.println(demo.subsequence(array.length, array));

    }

    public long subsequence(int n, int[] array) {
        // write code here
        if (n == 0) {
            return 0L;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = array[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1],dp[i - 2] + array[i - 1]);
        }

        return dp[n];
    }


}
