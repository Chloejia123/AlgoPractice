public class LC283MoveZeroes {
  public void moveZeroes(int[] nums) {
    int slow = 0, fast = 0;
    // two pointers, slow is used to keep track of the current slot, fast is used to find the next non-zero and swap it with slow
    for(fast = 0; fast < nums.length; fast++){
      if(nums[fast] == 0) continue;
      int temp = nums[fast];
      nums[fast] = nums[slow];
      nums[slow] = temp;
      slow++;
    }
  }
}
