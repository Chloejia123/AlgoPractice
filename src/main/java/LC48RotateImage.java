public class LC48RotateImage {
  class Solution {
    public void rotate(int[][] matrix) {
      if (matrix == null || matrix.length == 0) return;
      // rotate each cell's x-axis with y-axis
      for (int i = 0; i < matrix.length; i++) {
        for (int j = i; j < matrix[0].length; j++) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }

      // reverse each row to get the final result
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix.length / 2; j++) {
          int temp = matrix[i][j];
          matrix[i][j] = matrix[i][matrix.length - 1 - j];
          matrix[i][matrix.length - 1 - j] = temp;
        }
      }
    }
  }
}
