public class LC121BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    int max = 0, lo = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < lo) {
        lo = prices[i];
      }
      if (prices[i] - lo > max) {
        max = prices[i] - lo;
      }
    }
    return max;
  }
}
