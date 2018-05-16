public class LC507PerfectNumber {
  public boolean checkPerfectNumber(int num) {
    if (num == 1) return false;

    int sum = 0;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        sum += i + num / i; // i * num/i = num;
      }
    }
    sum++;

    return sum == num;
  }
}
