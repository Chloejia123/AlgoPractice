import java.util.Arrays;
import java.util.HashSet;

public class LC824GoatLatin {
  public static final Character[] al = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
  public static final HashSet<Character> vowels = new HashSet<>(Arrays.asList(al));

  class Solution {

    public String toGoatLatin(String S) {
      int count = 1;
      String[] words = S.split(" ");
      StringBuilder sb = new StringBuilder();
      for (String word : words) {
        count++;
        if (word.length() >= 1) {
          if (vowels.contains(word.charAt(0))) {
            word += "m";
          } else {
            word = word.substring(1) + word.charAt(0) + "m";
          }
          word = addAs(word, count);
          sb.append(word).append(" ");
        }
      }
      return sb.toString().trim();
    }

    private String addAs(String word, int count) {
      StringBuilder wordBuilder = new StringBuilder(word);
      while (count > 0) {
        wordBuilder.append("a");
        count--;
      }
      word = wordBuilder.toString();
      return word;
    }
  }
}