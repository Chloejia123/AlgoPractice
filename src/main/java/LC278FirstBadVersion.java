public class LC278FirstBadVersion {
  public int firstBadVersion(int n) {
    int lo = 0, hi = n;
    while (lo + 1 < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBadVersion(mid)) {
        hi = mid;
      } else {
        lo = mid;
      }
    }
    return isBadVersion(lo) ? lo : hi;
  }

  // this is created just for syntax check, not real method
  private boolean isBadVersion(int lo) {
    return true;
  }
}
