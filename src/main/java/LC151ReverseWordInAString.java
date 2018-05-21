public class LC151ReverseWordInAString {
  public String reverseWords(String s) {
    String[] words = s.trim().split("\\s+"); // split by one or more white space
    StringBuilder res = new StringBuilder();
    for (int i = words.length - 1; i > 0; i--) {
      res.append(words[i]).append(" ");
    }
    return res.append(words[0]).toString();
  }
}
