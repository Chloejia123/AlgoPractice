public class LC485MaxConsecutiveOnes {
  class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
      int localMax = 0, max = 0;
      for (int num : nums) {
        max = Math.max(max, localMax = num == 0 ? 0 : localMax + 1);
      }
      return max;
    }
  }
}
