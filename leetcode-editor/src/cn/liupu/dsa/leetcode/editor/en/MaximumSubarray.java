//Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum. 
//
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [0]
//Output: 0
// 
//
// Example 4: 
//
// 
//Input: nums = [-1]
//Output: -1
// 
//
// Example 5: 
//
// 
//Input: nums = [-2147483647]
//Output: -2147483647
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 10204 👎 492


package cn.liupu.dsa.leetcode.editor.en;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int length = nums.length;
            int[] dp = new int[length];
            dp[0] = nums[0];
            int maxSubArray = nums[0];

            for(int i = 1; i < length;i++){
                dp[i] = Math.max(nums[i],dp[i-1] + nums[i]);
                maxSubArray = Math.max(maxSubArray,dp[i]);
            }

            return maxSubArray;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}