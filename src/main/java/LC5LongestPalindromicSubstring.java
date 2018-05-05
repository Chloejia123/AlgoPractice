public class LC5LongestPalindromicSubstring {
  private int lo, maxLen;

  public String longestPalindrome(String s) {
    int len = s.length();
    if (len < 2)
      return s;

    for (int i = 0; i < len - 1; i++) {
      helper(s, i, i);  //assume odd length, try to extend Palindrome as possible
      helper(s, i, i + 1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
  }

  private void helper(String s, int j, int k) {
    // ensure within bound and check for palindromic pattern
    while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
      j--;
      k++;
    }

    // update new lo and maxLen for later substring operation
    if (maxLen < k - j - 1) {
      lo = j + 1;
      maxLen = k - j - 1;
    }
  }
}
