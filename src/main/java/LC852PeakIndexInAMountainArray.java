public class LC852PeakIndexInAMountainArray {
  class Solution {
    public int peakIndexInMountainArray(int[] A) {
      int lo = 0;
      int hi = A.length - 1;
      while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (A[mid] < A[mid + 1]) { // peak index is after mid.
          lo = mid + 1;
        }else if (A[mid -1] > A[mid]) { // peak index is before mid.
          hi = mid;
        }else { // peak index is mid.
          return mid;
        }
      }
      return -1; // no peak.
    }
  }
}
