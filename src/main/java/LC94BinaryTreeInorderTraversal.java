import java.util.ArrayList;
import java.util.List;

import Aux.TreeNode;

public class LC94BinaryTreeInorderTraversal {
  class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      traverse(res, root);
      return res;
    }

    void traverse(List<Integer> res, TreeNode root) {
      if (root == null) return;

      traverse(res, root.left);
      res.add(root.val);

      traverse(res, root.right);
    }
  }
}
