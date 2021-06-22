package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/6/20 4:30 下午
 **/
public class NC68_JumpFloor {

    public static void main(String[] args) {

        NC68_JumpFloor demo = new NC68_JumpFloor();
        int result = demo.jumpFloor(100);
        System.out.println(result);

    }


    public int jumpFloor(int target) {
        int[] dp = new int[target + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }
}
