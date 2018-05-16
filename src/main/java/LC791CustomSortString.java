import java.util.HashMap;
import java.util.Map;

public class LC791CustomSortString {
  public String customSortString(String s, String t) {
    int[] freq = new int[26];
    t.chars().forEach(c -> freq[c - 'a'] += 1);

    Map<Character, Character> seen = new HashMap<>();
    StringBuilder res = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (freq[c - 'a'] > 0) {
        seen.put(c, c);
        while (freq[c - 'a']-- > 0) res.append(c);
      }
    }
    for (char c : t.toCharArray()) {
      if (!seen.containsKey(c)) res.append(c);
    }
    return res.toString();
  }
}
