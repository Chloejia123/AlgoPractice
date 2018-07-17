public class LC312BurstBalloons {
  class Solution {
    public int maxCoins(int[] nums) {
      int n = nums.length;
      if (n == 0) return 0;
      int[][] dp = new int[n][n];
      return helper(nums, dp, 0, n-1, 1, 1);
    }

    private int helper(int[] nums, int[][] dp, int s, int e, int l, int r) {
      if (s == e) return l * nums[s] * r;
      int max = 0;
      for (int i = s; i <= e; i++) {
        int left = i==s ? 0 : dp[s][i-1] == 0 ? helper(nums, dp, s, i-1, l, nums[i]) : dp[s][i-1];
        int right = i==e ? 0 : dp[i+1][e] == 0 ? helper(nums, dp, i+1, e, nums[i], r) : dp[i+1][e];
        max = Math.max(max, left + right + l * nums[i] * r);
      }
      dp[s][e] = max;
      return max;
    }
  }
}
