public class LC6ZigZagConversion {
  public String convert(String s, int nRows) {
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

    int i = 0;
    while (i < s.length()) {
      for (int idx = 0; idx < nRows && i < s.length(); idx++) // vertically down
        sb[idx].append(s.charAt(i++));
      for (int idx = nRows - 2; idx >= 1 && i < s.length(); idx--) // obliquely up
        sb[idx].append(s.charAt(i++));
    }
    for (int idx = 1; idx < sb.length; idx++)
      sb[0].append(sb[idx]);
    return sb[0].toString();
  }
}
