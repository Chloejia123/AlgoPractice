public class LC746MinCostClimbingStairs {
  // Similar to climbing stairs but needs to maintain and compare the cost on each step.
  // DP can be used here to store the most cost-efficient steps so far on each slot
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
      int[] dp = new int[cost.length + 1];
      dp[0] = cost[0];
      dp[1] = cost[1];
      for (int i = 2; i <= cost.length; i++) {
        int costMv = (i == cost.length ? 0 : cost[i]);
        dp[i] = Math.min(dp[i - 1] + costMv, dp[i - 2] + costMv);
      }
      return dp[dp.length - 1];
    }
  }
}
