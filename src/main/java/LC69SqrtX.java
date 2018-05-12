public class LC69SqrtX {
  public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
    long start = 1, end = x;
    while (start + 1 < end) {
      long mid = start + (end - start) / 2;
      if (mid * mid <= x) {
        start = mid;
      } else {
        end = mid;
      }
    }
    return end * end <= x ? (int) end : (int) start;
  }
}
