public class LC365WaterAndJugProblem {
  class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
      if (x + y < z) return false;
      if (x == 0 && y == 0 && z == 0) return true;
      if (x + y == z || x == z || y == z) return true;
      return z % GCD(x, y) == 0;
    }

    private int GCD(int x, int y) {
      while (y != 0) {
        int temp = y;
        y = x % y;
        x = temp;
      }
      return x;
    }
  }
}
