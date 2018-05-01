import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC39CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    // step 1. 原数组去重，以防止结果有重复
    // 注意一个数可以选择很多次 index要从头开始loop
    if (candidates.length == 0) return null;
    List<List<Integer>> res = new ArrayList<>();
    int[] nums = removeDup(candidates);
    helper(nums, 0, new ArrayList<Integer>(), target, res);
    return res;
  }

  private void helper(int[] nums, int startIdx, ArrayList<Integer> comb, int target, List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(comb));
      return;
    }

    for (int i = startIdx; i < nums.length; i++) {
      if (nums[i] > target) {
        break;
      }

      comb.add(nums[i]);
      helper(nums, i, comb, target - nums[i], res);
      // backtracking step
      comb.remove(comb.size() - 1);
    }
  }

  // 双指针去重法
  private int[] removeDup(int[] nums) {
    if (nums.length <= 1) return nums;
    Arrays.sort(nums);
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != nums[index]) {
        nums[++index] = nums[i];
      }
    }
    return nums;
  }
}
