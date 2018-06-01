public class LC74SearchA2DMatrix {
  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
      if (matrix.length == 0 || matrix[0].length == 0) return false;
      int row = matrix.length, col = matrix[0].length;
      int lo = 0, hi = row * col - 1;
      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        int midVal = matrix[mid / col][mid % col];
        if (midVal == target) {
          return true;
        } else if (midVal < target) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      }
      return false;
    }
  }
}
