public class LC240SearchA2DmatrixII {
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return false;
      int rowNum = matrix.length, colNum = matrix[0].length;
      int row = 0;
      int col = colNum - 1; // up right corner
      while (row < rowNum && col >= 0) {
        if (target == matrix[row][col]) {
          return true;
        } else if (target < matrix[row][col]) { // if current number is larger than target, there is no need to look downwards because all numbers below current number is larger,
          col--;
        } else { // if current number is smaller than the target number, there is no need to look to the left of current number, because the entire row is sorted and everything to the left is smaller than current number
          row++;
        }
      }
      return false;
    }
  }

}
