import java.util.HashMap;
import java.util.Map;

public class LC532KDiffPairInAnArray {
  class Solution {
    public int findPairs(int[] nums, int k) {
      if (nums.length == 0 || nums == null || k < 0) return 0;
      Map<Integer, Integer> map = new HashMap<>();
      int count = 0;
      for (int n : nums) {
        map.put(n, map.getOrDefault(n, 0) + 1);
      }

      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (k == 0) {
          if (entry.getValue() >= 2) {
            count++;
          }
        } else {
          if (map.containsKey(entry.getKey() + k))
            count++;
        }
      }
      return count;
    }
  }

}
