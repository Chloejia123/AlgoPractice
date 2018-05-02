import java.util.ArrayList;
import java.util.List;

public class LC131PalindromePartitioning {
  public List<List<String>> partition(String s) {
    if (s.length() == 0 || s == null) return null;
    List<List<String>> res = new ArrayList<>();
    helper(s, 0, new ArrayList<String>(), res);
    return res;
  }

  private void helper(String s, int startIdx, List<String> path, List<List<String>> res) {
    if (startIdx == s.length()) { //切到最后面
      res.add(new ArrayList<>(path)); //deep copy
      return;
    }
    for (int i = startIdx; i < s.length(); i++) {
      String subStr = s.substring(startIdx, i + 1);
      if (!isPalindromic(subStr)) {
        continue;
      }
      path.add(subStr);
      helper(s, i + 1, path, res); // i + 1 代表着局部的深度搜索， startIdx局部不变
      path.remove(path.size() - 1);
    }
  }

  private boolean isPalindromic(String s) {
    if (s.length() == 0 || s == null) return false;
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) return false;
    }
    return true;
  }
}
