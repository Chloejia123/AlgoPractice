import java.util.ArrayList;
import java.util.List;

import Aux.TreeNode;

public class LC145BinaryTreePostorderTraversal {
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
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      traverse(root, res);
      return res;
    }

    void traverse(TreeNode root, List<Integer> res) {
      if (root == null) return;
      traverse(root.left, res);
      traverse(root.right, res);
      res.add(root.val);
    }
  }
}
