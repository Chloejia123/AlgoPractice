import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Aux.TreeNode;

// dfs solution
public class LC199BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    rightView(root, result, 0);
    return result;
  }

  public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
    if (curr == null) {
      return;
    }
    if (currDepth == result.size()) {
      result.add(curr.val);
    }

    rightView(curr.right, result, currDepth + 1);
    rightView(curr.left, result, currDepth + 1);

  }


  // level order bfs solution
  public List<Integer> rightSideView2(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) return res;

    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (i == 0) { // only get the first one from the right
          res.add(node.val);
        }
        if (node.right != null) queue.offer(node.right);
        if (node.left != null) queue.offer(node.left);
      }
    }
    return res;
  }
}
