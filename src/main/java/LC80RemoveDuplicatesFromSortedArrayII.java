public class LC80RemoveDuplicatesFromSortedArrayII {
  class Solution {
    public int removeDuplicates(int[] nums) {
      int i = 0;
      for (int n : nums)
        if (i < 2 || n > nums[i-2]) // first two must be qualified, n > nums[i-2] means current n
          // is not the same as the previous 2 numbers, so that should be stored to the result
          nums[i++] = n;
      return i;
    }
  }
}
