public class LC75SortColor {
  public void sortColors(int[] nums) {
    // one pass solution
    int count0 = 0, count1 = 0, count2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        count0++;
      } else if (nums[i] == 1) {
        count1++;
      } else if (nums[i] == 2) {
        count2++;
      }
    }

    for (int j = 0; j < nums.length; j++) {
      if (j < count0) {
        nums[j] = 0;
      } else if (j < count0 + count1) {
        nums[j] = 1;
      } else {
        nums[j] = 2;
      }
    }
  }


  // one pass version
  private static final int MAX = 3;

  public void sortColorsOnePass(int[] nums) {
    int[] buckets = new int[MAX];
    for(int num : nums) buckets[num]++;
    for(int p = 0, val = 0; val < MAX; val++) {
      for(int count = 0; count < buckets[val]; count++) {
        nums[p++] = val;
      }
    }
  }
}
