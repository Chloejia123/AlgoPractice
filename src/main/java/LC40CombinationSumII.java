import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC40CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (candidates.length == 0 || candidates == null) return null;
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    helper(candidates, 0, new ArrayList<Integer>(), target, res);
    return res;
  }

  private void helper(int[] candidates, int startIdx, List<Integer> comb, int target, List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<  >(comb));
      return;
    }
    if (target < 0) return;

    for (int i = startIdx; i < candidates.length; i++) {
      if (i > startIdx && candidates[i] == candidates[i - 1]) { // 除了第一个以外的 遇见一样的数字就跳过，因为已经sorted所以成立
        continue;
      }
      comb.add(candidates[i]);
      helper(candidates, i + 1, comb, target - candidates[i], res); // i+1 ensures no duplicated values
      comb.remove(comb.size() - 1); // backtracking step
    }
  }
}
