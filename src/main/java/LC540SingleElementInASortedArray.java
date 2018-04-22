public class LC540SingleElementInASortedArray {
  public int singleNonDuplicate(int[] nums) {
    // binary search
    int n = nums.length, lo = 0, hi = n / 2;
    while (lo < hi) {
      int m = (lo + hi) / 2;
      if (nums[2 * m] == nums[2 * m + 1]) lo = m + 1;
      else hi = m;
    }
    return nums[2 * lo];
  }
}
