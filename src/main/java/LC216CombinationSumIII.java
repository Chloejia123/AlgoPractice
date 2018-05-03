import java.util.ArrayList;
import java.util.List;

public class LC216CombinationSumIII {
  public List<List<Integer>> combinationSum3(int k, int n) {
    if (k <= 0 || n <= 0) return null;
    List<List<Integer>> res = new ArrayList<>();
    helper(res, 1, new ArrayList<Integer>(), k, n);
    return res;
  }

  private void helper(List<List<Integer>> res, int start, List<Integer> comb, int k, int n) {
    if (comb.size() == k && n == 0) { //结束条件是k个数字的count已用完而且n已经被减到0
      res.add(new ArrayList<Integer>(comb));
      return;
    }

    for (int i = start; i <= 9; i++) {
      comb.add(i);
      helper(res, i + 1, comb, k, n - i); // 为了防止duplicate，i+1， n-i是为了在下一步recurse的时候更新n
      comb.remove(comb.size() - 1);
    }
  }
}
