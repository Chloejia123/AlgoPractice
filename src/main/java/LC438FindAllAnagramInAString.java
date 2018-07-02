import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC438FindAllAnagramInAString {
  public class Solution {
    public List<Integer> findAnagrams(String s, String t) {
      List<Integer> res = new ArrayList<Integer>();
      Map<Character, Integer> map = new HashMap<Character, Integer>();//<all char, freq in t>
      for (char c : s.toCharArray()) map.put(c, 0);
      for (char c : t.toCharArray()) {
        if (map.containsKey(c))
          map.put(c, map.get(c) + 1);
        else
          return res;
      }
      int start = 0, end = 0;
      int counter = t.length();
      while (end < s.length()) {
        char cur = s.charAt(end);
        if (map.get(cur) > 0) counter--; // if last char cur is in t, counter--
        map.put(cur, map.get(cur) - 1); // decrement the value of cur in the map
        while (counter == 0) { // only if counter == 0,
          if (end - start + 1 == t.length()) res.add(start);
          char c2 = s.charAt(start);
          map.put(c2, map.get(c2) + 1);
          if (map.get(c2) > 0) counter++;
          start++;
        }
        end++;
      }
      return res;
    }
  }
}
