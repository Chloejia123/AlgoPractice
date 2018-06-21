public class LC186ReverseWordInAStringII {
  class Solution {
    // Time: O(n),
    public void reverseWords(char[] str) {
      if (str == null || str.length == 0) return;
      // big reverse
      reverse(str, 0, str.length - 1);
      int l = 0;
      //O(n)
      for (int r = 0; r < str.length; r++) {
        if (str[r] == ' ') {
          reverse(str, l, r - 1);
          l = r + 1;
        } else if (r == str.length - 1) {
          reverse(str, l, r);
        }

      }
    }

    // O(n/2)
    private void reverse(char[] str, int i, int j) {
      //big reverse
      while (i < j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
        i++;
        j--;
      }
    }
  }

}
