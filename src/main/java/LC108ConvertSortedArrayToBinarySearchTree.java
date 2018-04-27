import Aux.TreeNode;

public class LC108ConvertSortedArrayToBinarySearchTree {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) return null;
    TreeNode root = helper(nums, 0, nums.length - 1);
    return root;
  }

  private TreeNode helper(int[] nums, int lo, int hi) {
    if (lo > hi) return null;
    int mid = lo + (hi - lo) / 2;
    TreeNode node = new TreeNode(nums[mid]);
    node.left = helper(nums, lo, mid - 1); // 注意边界问题 要不含mid
    node.right = helper(nums, mid + 1, hi);
    return node;
  }
}


