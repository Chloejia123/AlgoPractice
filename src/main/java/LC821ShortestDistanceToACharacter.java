public class LC821ShortestDistanceToACharacter {
  class Solution {
    public int[] shortestToChar(String S, char C) {
      int[] res = new int[S.length()];
      int start = S.indexOf(C);
      int end = S.indexOf(C, start + 1);
      for(int i = 0; i < S.length(); i++){
        if(i < start){
          res[i] = start - i;
        }else if(i >= start && i <= end && start < end){
          res[i] = Math.min(i-start, end - i);
          if(i == end){
            start = end;
            end = S.indexOf(C, start + 1);
          }
        }else{
          res[i] = i - start;
        }
      }
      return res;
    }
  }

}
