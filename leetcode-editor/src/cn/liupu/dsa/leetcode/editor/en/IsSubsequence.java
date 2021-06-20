//Given a string s and a string t, check if s is subsequence of t.
//
// A subsequence of a string is a new string which is formed from the original s
//tring by deleting some (can be none) of the characters without disturbing the re
//lative positions of the remaining characters. (ie, "ace" is a subsequence of "ab
//cde" while "aec" is not). 
//
// Follow up: 
//If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you w
//ant to check one by one to see if T has its subsequence. In this scenario, how w
//ould you change your code? 
//
// Credits: 
//Special thanks to @pbrother for adding this problem and creating all test case
//s. 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// Both strings consists only of lowercase characters. 
// 
// Related Topics Binary Search Dynamic Programming Greedy 
// 👍 2072 👎 223


package cn.liupu.dsa.leetcode.editor.en;

public class IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int m = s.length(), n = t.length();

            boolean[][] dp = new boolean[m + 1][n + 1];

            for (int j = 0; j < n + 1; j++) {
                dp[0][j] = true;
            }

            for (int i = 1; i < m + 1; i++) {
                for (int j = 0; j < n + 1; j++) {
                    if(i > j){
                        dp[i][j] = false;
                    }else{
                        if(s.charAt(i-1) == t.charAt(j-1)){
                            dp[i][j] = dp[i-1][j-1];
                        }else{
                            dp[i][j] = dp[i][j-1];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}