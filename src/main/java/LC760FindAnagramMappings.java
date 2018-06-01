import java.util.HashMap;
import java.util.Map;

public class LC760FindAnagramMappings {
  class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
      int[] res = new int[A.length];
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < B.length; i++) {
        if (!map.containsKey(B[i])) {
          map.put(B[i], i);
        } else {
          continue;
        }
      }
      for (int i = 0; i < A.length; i++) {
        res[i] = map.get(A[i]);
      }
      return res;
    }
  }
}
