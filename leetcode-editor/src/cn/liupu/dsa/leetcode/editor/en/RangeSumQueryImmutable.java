//Given an integer array nums, find the sum of the elements between indices i an
//d j (i ≤ j), inclusive. 
//
// Implement the NumArray class: 
//
// 
// NumArray(int[] nums) Initializes the object with the integer array nums. 
// int sumRange(int i, int j) Return the sum of the elements of the nums array i
//n the range [i, j] inclusive (i.e., sum(nums[i], nums[i + 1], ... , nums[j])) 
// 
//
// 
// Example 1: 
//
// 
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]
//
//Explanation
//NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
//numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
//numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
//numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 0 <= i <= j < nums.length 
// At most 104 calls will be made to sumRange. 
// 
// Related Topics Dynamic Programming 
// 👍 1115 👎 1246


package cn.liupu.dsa.leetcode.editor.en;

public class RangeSumQueryImmutable {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new RangeSumQueryImmutable().new NumArray(nums);
        int result = numArray.sumRange(1, 4);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            sum = new int[nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                sum[i+1] += sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j+1] - sum[i];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
//leetcode submit region end(Prohibit modification and deletion)

}