public class LC788RotatedDigits {
  public int rotatedDigits(int num) {
    int count = 0;
    for (int i = 1; i <= num; i++) {
      if (isValid(i)) count++;
    }
    return count;
  }

  public boolean isValid(int num) {
    // if num is divisible of 2, 5, 6, 9, it is valid, otherwise it is not valid
    boolean validFound = false;
    while (num > 0) {
      if (num % 10 == 2) validFound = true;
      if (num % 10 == 5) validFound = true;
      if (num % 10 == 6) validFound = true;
      if (num % 10 == 9) validFound = true;
      if (num % 10 == 3) return false;
      if (num % 10 == 4) return false;
      if (num % 10 == 7) return false;
      num = num / 10;
    }
    return validFound;
  }
}
