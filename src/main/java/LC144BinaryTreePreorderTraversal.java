import java.util.ArrayList;
import java.util.List;

import Aux.TreeNode;

public class LC144BinaryTreePreorderTraversal {
  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      traverse(root, res);
      return res;
    }

    void traverse(TreeNode root, List<Integer> res) {
      if (root == null) return;
      res.add(root.val);

      traverse(root.left, res);
      traverse(root.right, res);
    }
  }
}
