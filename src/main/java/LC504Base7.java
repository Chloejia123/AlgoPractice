public class LC504Base7 {
  public String convertToBase7(int num) {
    // if this number is less than zero, it should be converted a minus sign
    if (num < 0) {
      return "-" + convertToBase7(-num);
    }
    // if this number is less than 7, convert it to string
    if (num < 7) {
      return "" + num;
    }
    return convertToBase7(num / 7) + num % 7;
  }


  // this is a simple approach
  public String convertToBase7V2(int num) {
    return Integer.toString(num, 7);
  }
}
