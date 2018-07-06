import Aux.TreeNode;

public class LC270ClosestBinarySearchTreeValue {
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
    public int closestValue(TreeNode root, double target) {
      int res = root.val;
      while (root != null) {
        if (Math.abs(target - root.val) < Math.abs(target - res)) {
          res = root.val;
        }
        if (target < root.val) {
          root = root.left;
        } else {
          root = root.right;
        }
      }
      return res;
    }
  }
}
