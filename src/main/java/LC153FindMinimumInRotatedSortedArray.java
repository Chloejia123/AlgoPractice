public class LC153FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    if (nums.length == 0 || nums == null) return -1;
    if (nums.length == 1) {
      return nums[0];
    }
    int target = nums[nums.length - 1];
    int lo = 0, hi = nums.length - 1;
    while (lo + 1 < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] <= target) {
        hi = mid;
      } else {
        lo = mid;
      }
    }

    if (nums[lo] <= target) {
      return nums[lo];
    } else {
      return nums[hi];
    }

  }
}
