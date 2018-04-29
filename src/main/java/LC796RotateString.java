public class LC796RotateString {
  public boolean rotateString(String A, String B) {
    // first to check whether their lengths are the same
    // then if B is a rotated string of A, two A combined should construct a B
    return (A.length() == B.length()) && ((A + A).contains(B));
  }
}
