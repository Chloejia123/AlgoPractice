public class LC258AddDigits {
  class Solution {
    public int addDigits(int num) {
      int first = 0, remain = 0, sum = 0;
      while (num != 0) {
        first = num / 10;
        remain = num % 10;
        sum += remain;
        num /= 10;
      }
      if (sum / 10 == 0) return sum;
      else return addDigits(sum);
    }
  }
}
