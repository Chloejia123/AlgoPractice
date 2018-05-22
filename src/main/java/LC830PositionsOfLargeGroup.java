import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC830PositionsOfLargeGroup {
    public List<List<Integer>> largeGroupPositions(String S) {
      int i = 0, j = 0, N = S.length();
      List<List<Integer>> res = new ArrayList<>();
      while (j < N) {
        while (j < N && S.charAt(j) == S.charAt(i)) ++j;
        if (j - i >= 3) res.add(Arrays.asList(i, j - 1));
        i = j;
      }
      return res;
    }
}
