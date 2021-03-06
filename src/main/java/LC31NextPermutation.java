public class LC31NextPermutation {
  class Solution {
    public void nextPermutation(int[] nums) {
      if (nums == null || nums.length < 2) return;
      int firstSmall = -1;
      for (int i = nums.length - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
          firstSmall = i;
          break;
        }
      }

      if (firstSmall == -1) {
        reverse(nums, 0, nums.length - 1);
        return;
      }

      int firstLarge = -1;
      for (int j = nums.length - 1; j >= 0; j--) {
        if (nums[j] > nums[firstSmall]) {
          firstLarge = j;
          break;
        }
      }
      swap(nums, firstSmall, firstLarge);
      reverse(nums, firstSmall + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
      while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
      }
    }
  }
}
