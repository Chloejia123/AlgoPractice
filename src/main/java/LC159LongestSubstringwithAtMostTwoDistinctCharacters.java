import java.util.HashMap;
import java.util.Map;

public class LC159LongestSubstringwithAtMostTwoDistinctCharacters {
  class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      if (s == null || s.length() == 0) return 0;
      int start = 0, end = 0, max = 0, count = 0;
      Map<Character, Integer> map = new HashMap<>(); // key: char in s, value: its occurrence
      while (end < s.length()) {
        char curr = s.charAt(end++);
        map.put(curr, map.getOrDefault(curr, 0) + 1); // store number of occurrences of each char in s
        if (map.get(curr) == 1) count++; // one distinct char is found

        while (count > 2) {
          char cStart = s.charAt(start);
          map.put(cStart, map.get(cStart) - 1); // decrease the frequency of cStart in map
          if (map.get(cStart) == 0) { // if cStart only appears once
            count--;
          }
          start++;
        }
        max = Math.max(max, end - start);
      }
      return max;
    }
  }
}
