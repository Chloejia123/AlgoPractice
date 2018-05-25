import java.util.HashSet;
import java.util.Set;

public class LC575DistributeCandies {
  class Solution {
    public int distributeCandies(int[] candies) {
      Set<Integer> kinds = new HashSet<>();
      for (int candy : candies) kinds.add(candy);
      return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
  }
}
