public class LC322CoinChange {
  public class Solution {
    public int coinChange(int[] A, int M) {
      int[] f = new int[M + 1]; // 创一个存结果的array
      int n = A.length;

      f[0] = 0; // 初始状态，得出0元面值需要0个硬币
      int i, j;
      for (i = 1; i <= M; ++i) {
        f[i] = -1;
        for (j = 0; j < n; ++j) {
          if (i >= A[j] && f[i - A[j]] != -1) {
            if (f[i] == -1 || f[i - A[j]] + 1 < f[i]) {
              f[i] = f[i - A[j]] + 1;
            }
          }
        }
      }

      return f[M];
    }
  }
}
