import java.util.ArrayList;
import java.util.List;

import Aux.TreeNode;

public class LC113PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
      List<List<Integer>> res = new ArrayList<>();
      helper(root, new ArrayList<Integer>(), sum, res);
      return res;
    }
    void helper(TreeNode root, List<Integer> path, int sum, List<List<Integer>> res){
      if(root == null) return;
      sum -= root.val;
      if (root.left == null && root.right == null) {
        if (sum == 0){
          path.add(root.val);
          res.add(new ArrayList<Integer>(path));
          path.remove(path.size()-1);
        }
        return;
      }
      path.add(root.val);
      helper(root.left, path, sum, res);
      helper(root.right, path, sum, res);
      path.remove(path.size()-1);

    }
}
