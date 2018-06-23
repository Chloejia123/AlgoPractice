public class LC63UniquePathsII {
  class Solution {
    // 1. when either row.len == 0 or col.len == 0 return 0
    // 2. create a 2d matrix int[][] f to store ways to get to the bottom right corner
    // 3. if current cell is obstacle, A[i][j] == 1, f[i][j] = 0;
    // 4. set the top left corner to 1, because it means there is only one possible way to get there
    // 4.5 if the row is 0 or col is 0, set f[][] to 0
    // 5. set cell to 0 first, then if the above row is not the second row, curr cell += above cell
    // 6. if the left col is not the second col, curr cell += left cell;
    // 7. return the bottom right corner cell f[m-1][n-1];
    public int uniquePathsWithObstacles(int[][] A) {
      int m = A.length;
      if (m == 0) return 0;

      int n = A[0].length;
      if (n == 0) return 0;

      int[][] f = new int[m][n];
      f[0][0] = 1;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (A[i][j] == 1) f[i][j] = 0; // if obstacle
          else {
            if (i == 0 && j == 0) {
              f[i][j] = 1;
            } else {
              f[i][j] = 0;
              if (i >= 1) {
                f[i][j] += f[i - 1][j];
              }
              if (j >= 1) {
                f[i][j] += f[i][j - 1];
              }
            }
          }
        }
      }
      return f[m - 1][n - 1];

    }
  }
}
