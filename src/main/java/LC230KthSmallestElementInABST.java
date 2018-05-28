import Aux.TreeNode;

public class LC230KthSmallestElementInABST {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   * int val;
   * TreeNode left;
   * TreeNode right;
   * TreeNode(int x) { val = x; }
   * }
   */
  class Solution {
    int count = 0;
    int res = Integer.MAX_VALUE;

    public int kthSmallest(TreeNode root, int k) {
      traverse(root, k);
      return res;
    }

    private void traverse(TreeNode root, int k) {
      if (root == null) return;
      traverse(root.left, k);
      count++;
      if (count == k)
        res = root.val;
      if (count < k)
        traverse(root.right, k);
    }
  }
}
