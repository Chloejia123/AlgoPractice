import java.util.ArrayList;
import java.util.List;

public class LC51NQueens {
  public List<List<String>> solveNQueens(int n) {
    if (n <= 0) return null;
    List<List<String>> res = new ArrayList<>();
    search(res, new ArrayList<Integer>(), n);
    return res;
  }

  // 这里就是普通的dfs搜索步骤
  private void search(List<List<String>> res, List<Integer> cols, int n) {
    if (cols.size() == n) {
      res.add(drawChessboard(cols));
      return;
    }
    for (int i = 0; i < n; i++) {
      if (!isValid(cols, i)) {
        continue;
      }
      cols.add(i);
      search(res, cols, n); // why n here?
      cols.remove(cols.size() - 1);
    }
  }

  // 将一个List<Integer> 转化成Q和点的组合
  private List<String> drawChessboard(List<Integer> cols) {
    List<String> chessboard = new ArrayList<>();
    for (int i = 0; i < cols.size(); i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < cols.size(); j++) {
        sb.append(j == cols.get(i) ? 'Q' : '.');
      }
      chessboard.add(sb.toString());
    }
    return chessboard;
  }

  // 查是否有同一个直线，对角线的Queen，如果有就return false
  private boolean isValid(List<Integer> cols, int column) {
    int row = cols.size();
    for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
      if (cols.get(rowIndex) == column) {
        return false;
      }
      if (rowIndex + cols.get(rowIndex) == row + column) { // 检查'/'对角线
        return false;
      }
      if (rowIndex - cols.get(rowIndex) == row - column) { // 检查'\'对角线
        return false;
      }
    }
    return true;
  }
}
