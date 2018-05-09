public class LC344ReverseString {
  public String reverseString(String s) {
    if (s.length() == 0 || s == null) return "";
    char[] chars = s.toCharArray();
    int i = 0, j = s.length() - 1;
    while (i < j) {
      char temp = chars[i];
      chars[i] = chars[j];
      chars[j] = temp;
      i++;
      j--;
    }
    return new String(chars);
  }
}
