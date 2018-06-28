import java.util.ArrayList;
import java.util.List;

public class LC763PartitionLabels {
  class Solution {
    public List<Integer> partitionLabels(String S) {
      if (S == null || S.length() == 0) return null;
      List<Integer> list = new ArrayList<>();
      int[] dict = new int[26];
      // record the last occurence index of each char
      for (int i = 0; i < S.length(); i++) {
        dict[S.charAt(i) - 'a'] = i;
      }

      int start = 0;
      int end = 0;
      for (int j = 0; j < S.length(); j++) {
        end = Math.max(end, dict[S.charAt(j) - 'a']);
        if (end == j) {
          list.add(end - start + 1);
          start = end + 1;
        }
      }
      return list;
    }
  }
}
