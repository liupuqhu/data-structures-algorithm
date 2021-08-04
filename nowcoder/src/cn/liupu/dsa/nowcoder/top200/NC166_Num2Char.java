package cn.liupu.dsa.nowcoder.top200;

/**
 * @description:
 * @author: liupu1
 * @create: 2021/8/3 11:43 下午
 **/
public class NC166_Num2Char {

    public static void main(String[] args) {

        NC166_Num2Char demo = new NC166_Num2Char();

        int result = demo.solve("31717126241541717");
        System.out.println(result);
    }

    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public int solve(String nums) {
        // write code here
        int[] dp = new int[nums.length() + 1];

        for (int i = 1; i <= nums.length(); i++) {
            if (i == 1) {
                int cur = Integer.valueOf(nums.substring(0, 1));
                if (cur >= 1 && cur <= 26) {
                    dp[i] = 1;
                }
                continue;
            }

            if (i == 2) {
                int pre = Integer.valueOf(nums.substring(0, 1));
                int cur = Integer.valueOf(nums.substring(1, 2));
                int tmp = Integer.valueOf(nums.substring(0, 2));

                if (!isValid(cur) && !isValid(tmp)) {
                    return 0;
                }

                if (isValid(cur)) {
                    if (pre >= 1 && pre <= 2 && isValid(tmp)) {
                        dp[i] = dp[i - 1] + 1;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
                continue;
            }

            int pre = Integer.valueOf(nums.substring(i - 2, i - 1));
            int cur = Integer.valueOf(nums.substring(i - 1, i));
            int tmp = Integer.valueOf(nums.substring(i - 2, i));

            if (!isValid(cur) && !isValid(tmp)) {
                return 0;
            }
            if (isValid(cur)) {
                if (pre >= 1 && pre <= 2 && isValid(tmp)) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }

        }

        return dp[nums.length()];
    }

    public boolean isValid(int num) {
        return num >= 1 && num <= 26;
    }

}
