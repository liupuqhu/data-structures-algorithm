//Alice and Bob take turns playing a game, with Alice starting first.
//
// Initially, there is a number N on the chalkboard. On each player's turn, that
// player makes a move consisting of: 
//
// 
// Choosing any x with 0 < x < N and N % x == 0. 
// Replacing the number N on the chalkboard with N - x. 
// 
//
// Also, if a player cannot make a move, they lose the game. 
//
// Return True if and only if Alice wins the game, assuming both players play op
//timally. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: 2
//Output: true
//Explanation: Alice chooses 1, and Bob has no more moves.
// 
//
// 
// Example 2: 
//
// 
//Input: 3
//Output: false
//Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
// 
//
// 
//
// Note: 
//
// 
// 1 <= N <= 1000 
// 
// 
// Related Topics Math Dynamic Programming 
// 👍 621 👎 1715


package cn.liupu.dsa.leetcode.editor.en;

public class DivisorGame {
    public static void main(String[] args) {
        Solution solution = new DivisorGame().new Solution();
        boolean result = solution.divisorGame(1);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean divisorGame(int N) {
            return N % 2 == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}