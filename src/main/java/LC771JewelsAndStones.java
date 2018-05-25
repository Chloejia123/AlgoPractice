import java.util.HashMap;
import java.util.Map;

public class LC771JewelsAndStones {
  class Solution {
    public int numJewelsInStones(String J, String S) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i< J.length(); i++){
        if(!map.containsKey(J.charAt(i))){
          map.put(J.charAt(i), 1);
        }
      }
      int count = 0;
      for (int j = 0; j < S.length(); j++){
        if(map.containsKey(S.charAt(j))){
          count++;
        }
      }
      return count;
    }
  }
}
