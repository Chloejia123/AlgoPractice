import java.util.HashMap;
import java.util.Map;

public class LC169MajorElement {

  public class Solution {
    public int majorityElement(int[] num) {

      int major = num[0], count = 1;
      for (int i = 1; i < num.length; i++) {
        if (count == 0) {
          count++;
          major = num[i];
        } else if (major == num[i]) {
          count++;
        } else count--;

      }
      return major;

    }
  }

  public int majorityElement2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      if (map.containsKey(n)) {
        map.put(n, map.get(n) + 1);
      } else {
        map.put(n, 1);
      }
    }
    int res = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > nums.length / 2) {
        res = entry.getKey();
      }
    }
    return res;
  }

  // moore voting method
  public int majorityElement3(int[] nums) {
    int count=0, ret = 0;
    for (int num: nums) {
      if (count==0)
        ret = num;
      if (num!=ret)
        count--;
      else
        count++;
    }
    return ret;
  }
}