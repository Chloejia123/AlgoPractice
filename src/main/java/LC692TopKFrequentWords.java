import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LC692TopKFrequentWords {
  class Solution {
    public List<String> topKFrequent(String[] words, int k) {
      if (words.length == 0 || words == null || k == 0) return null;
      Map<String, Integer> map = new HashMap<>();
      List<String> res = new ArrayList<>();
      PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((o1, o2) -> (o1.getValue() == o2.getValue() ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue()));

      for (String w : words) {
        map.put(w, map.getOrDefault(w, 0) + 1);
      }
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        pq.offer(entry);
        if (pq.size() > k) pq.poll();
      }

      while (!pq.isEmpty())
        res.add(0, pq.poll().getKey());

      return res;
    }
  }
}
