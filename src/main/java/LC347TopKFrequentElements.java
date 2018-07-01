import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC347TopKFrequentElements {
  class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
      List<Integer> res = new ArrayList<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      List<Integer>[] bucket = new List[nums.length + 1];
      for (int key : map.keySet()) {
        int freq = map.get(key);
        if (bucket[freq] == null) bucket[freq] = new ArrayList<Integer>();
        bucket[freq].add(key);
      }
      for (int i = bucket.length - 1; i >= 0; i--) {
        if (bucket[i] != null && res.size() < k) {
          res.addAll(bucket[i]);
        }
      }
      return res;
    }
  }
}
