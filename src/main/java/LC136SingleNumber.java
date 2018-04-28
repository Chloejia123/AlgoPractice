public class LC136SingleNumber {
  public int singleNumber(int[] nums) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      result ^= nums[i]; // if a number appear twice, it will be offset and the result -> 0
    }
    return result;
  }
}
