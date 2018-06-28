public class LC200NumberOfIslands {
  class Solution {
    private int row;
    private int col;

    public int numIslands(char[][] grid) {
      row = grid.length;
      if (grid == null || row == 0) return 0;
      col = grid[0].length;

      int count = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (grid[i][j] == '1') {
            dfsMarking(grid, i, j);
            count++;
          }
        }
      }
      return count;
    }

    private void dfsMarking(char[][] grid, int i, int j) {
      if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
      grid[i][j] = '0';
      dfsMarking(grid, i - 1, j);
      dfsMarking(grid, i + 1, j);
      dfsMarking(grid, i, j - 1);
      dfsMarking(grid, i, j + 1);
    }

  }
}
