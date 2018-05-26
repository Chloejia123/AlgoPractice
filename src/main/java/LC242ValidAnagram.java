public class LC242ValidAnagram {
  class Solution {
    public boolean isAnagram(String s, String t) {
      int[] alphabet = new int['z' - 'a' + 1];
      for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
      for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
      for (int i : alphabet) {
        if (i != 0)
          return false;
      }
      return true;
    }
  }
}
