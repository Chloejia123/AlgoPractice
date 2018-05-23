import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139WordBreak {
  class Solution {
    // step 1, turn that list of string to a set as a word dictionary
    // step 2, created an array of booleans, each stores whether the previous substrings is validated
    // step 3, use nested for loops to check back and store the boolean result for each slot
    // returns the last boolean value which indicates whether all the previous substring fullfill the requirements
    // Time: O(n^2), Space: O(n)
    public boolean wordBreak(String s, List<String> wordDict) {
      Set<String> set = new HashSet<>(wordDict);
      boolean[] dp = new boolean[s.length()+1];
      dp[0] = true;
      for(int i = 1; i <= s.length(); i++){
        for(int j = 0; j < i; j++){
          if(dp[j] && set.contains(s.substring(j,i))){
            dp[i] = true;
            break;
          }
        }
      }
      return dp[s.length()];
    }
  }
}
