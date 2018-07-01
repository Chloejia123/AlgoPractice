import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC451SortCharactersByFrequency {
  class Solution {
    public String frequencySort(String s) {
      if (s == null || s.length() == 0) return "";
      char[] letters = s.toCharArray();
      Map<Character, Integer> map = new HashMap<>();
      for (char c : letters) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((o1, o2) -> (o2.getValue() - o1.getValue()));
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        pq.offer(entry);
      }
      StringBuilder sb = new StringBuilder();

      while (!pq.isEmpty()) {
        Map.Entry<Character, Integer> entry = pq.poll();
        int i = 0;
        while (i++ < entry.getValue()) {
          sb.append(entry.getKey());
        }
      }
      return sb.toString();
    }
  }

  class Solution2 {
    public String frequencySort(String s) {
      if (s == null || s.length() == 0) return "";
      char[] letters = s.toCharArray();
      Map<Character, Integer> map = new HashMap<>();
      for (char c : letters) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      List<Character>[] bucket = new List[s.length() + 1];
      for (char key : map.keySet()) {
        int frequency = map.get(key);
        if (bucket[frequency] == null) {
          bucket[frequency] = new ArrayList<>();
        }
        bucket[frequency].add(key);
      }
      StringBuilder sb = new StringBuilder();

      for (int i = bucket.length - 1; i >= 0; i--) { //O(s.length() + 1)
        if (bucket[i] != null && sb.length() < s.length()) {
          for (Character c : bucket[i]) { //O(length of each bucket)
            for (int j = 0; j < i; j++) { //
              sb.append(c);
            }
          }
        }
      }

      return sb.toString();
    }
  }
}


