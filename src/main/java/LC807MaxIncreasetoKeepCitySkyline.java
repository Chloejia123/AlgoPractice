//[ [3, 0, 8, 4],
//  [2, 4, 5, 7],
//  [9, 2, 6, 3],
//  [0, 3, 1, 0] ]

// The skyline viewed from top or bottom is: [9, 4, 8, 7]
// The skyline viewed from left or right is: [8, 7, 9, 3]

// gridNew = [[8, 4, 8, 7],
//            [7, 4, 7, 7],
//            [9, 4, 8, 7],
//            [3, 3, 3, 3] ]

public class LC807MaxIncreasetoKeepCitySkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int row = grid.length; // get row length
    int col = grid[0].length; // get col length
    int top[] = new int[row]; // The skyline viewed from top or bottom
    int left[] = new int[col]; // The skyline viewed from left or right
    // fill skyline views
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        top[i] = Math.max(top[i], grid[i][j]);
        left[j] = Math.max(left[j], grid[i][j]);
      }
    }
    int sum = 0;
    // The difference between grid[i][j] and new grid should be added to sum
    // new grid - is nothing but minimum of either top[i] or left[j]
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        sum += Math.min(top[i], left[j]) - grid[i][j];
      }
    }
    return sum;
  }
}
