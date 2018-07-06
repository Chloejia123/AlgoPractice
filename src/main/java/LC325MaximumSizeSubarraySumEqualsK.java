import java.util.HashMap;
import java.util.Map;

public class LC325MaximumSizeSubarraySumEqualsK {
  class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
      if (nums == null || nums.length == 0) return 0;
      int max = 0, sum = 0;
      Map<Integer, Integer> map = new HashMap<>(); // Key: sum of all elements before index i, Value: index i
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        if (sum == k) {
          max = i + 1;
        } else if (map.containsKey(sum - k)) {
          max = Math.max(max, i - map.get(sum - k));
        }
        if (!map.containsKey(sum)) {
          map.put(sum, i);
        }
      }
      return max;
    }
  }
}
