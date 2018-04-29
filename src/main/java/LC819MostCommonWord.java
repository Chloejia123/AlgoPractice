import java.util.HashMap;
import java.util.Map;

public class LC819MostCommonWord {
  public String mostCommonWord(String paragraph, String[] banned) {
    String[] words = paragraph.split("[ !?',;.]+");
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0) + 1);
    }
    for (String word : banned) {
      if (map.containsKey(word.toLowerCase())) map.remove(word.toLowerCase());
    }
    String res = null;
    for (String word : map.keySet()) {
      if (res == null || map.get(word) > map.get(res))
        res = word;
    }
    return res;
  }
}
