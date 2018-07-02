import java.util.HashMap;
import java.util.Map;

public class LC340LongestSubstringwithAtMostKDistinctCharacters {
  class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
      if (s == null || s.length() == 0) return 0;
      int i = 0, j = 0, max = 0, count = 0;
      Map<Character, Integer> map = new HashMap<>();
      while (j < s.length()) {
        char curr = s.charAt(j++);
        map.put(curr, map.getOrDefault(curr, 0) + 1);
        if (map.get(curr) == 1) count++;

        while (count > k) {
          char cStart = s.charAt(i++);
          map.put(cStart, map.get(cStart) - 1);
          if (map.get(cStart) == 0) count--;
        }
        max = Math.max(max, j - i);
      }
      return max;
    }
  }
}
