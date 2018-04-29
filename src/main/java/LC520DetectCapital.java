public class LC520DetectCapital {
  public boolean detectCapitalUse(String word) {
    if (word.equals(word.toUpperCase())) {// check AAA
      return true;
    } else if (word.equals(word.toLowerCase())) // check aaa
      return true;
    else if (word.charAt(0) == word.toUpperCase().charAt(0)) { // check Aaa
      return word.substring(1).equals(word.substring(1).toLowerCase());
    }
    return false; // else is not valid
  }

}
