public class LC5LongestPalindromicSubstring {
  class Solution {
    String res = "";

    public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) return null;
      for (int i = 0; i < s.length(); i++) {
        helper(s, i, i);// odd
        helper(s, i, i + 1); // even
      }
      return res;
    }

    private void helper(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      String curr = s.substring(left + 1, right);
      if (res.length() < curr.length()) {
        res = curr;
      }
    }
  }

// Time: O(n^2)
// Space: O(1)


  class Solution2 {
    public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) return null;
      int n = s.length();
      boolean[][] dp = new boolean[n][n];

      String res = null;
      for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
          dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

          if (dp[i][j] && (res == null || res.length() < j - i + 1)) {
            res = s.substring(i, j + 1);
          }
        }
      }
      return res;
    }
  }

  // Time: O(n^2)
  // Space: O(n^2)
}



