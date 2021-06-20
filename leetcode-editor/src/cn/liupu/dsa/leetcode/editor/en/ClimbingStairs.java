  //You are climbing a staircase. It takes n steps to reach the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
//u climb to the top? 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 45 
// 
// Related Topics Dynamic Programming 
// 👍 5621 👎 179

  
  package cn.liupu.dsa.leetcode.editor.en;
  public class ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new ClimbingStairs().new Solution();
          int num = solution.climbStairs(6);
          System.out.println(num);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int first = 1;
        int second = 2;
        int num = 0;

        for(int i = 3;i <= n; i++){
            num = first + second;
            first = second;
            second = num;
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }