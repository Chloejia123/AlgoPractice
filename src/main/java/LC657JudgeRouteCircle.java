public class LC657JudgeRouteCircle {
  class Solution {
    public boolean judgeCircle(String moves) {
      int x = 0, y = 0;
      if(moves == null) return false;
      for(int i = 0; i < moves.length(); i++){
        switch (moves.charAt(i)){
          case 'R':
            x++;
            break;
          case 'L':
            x--;
            break;
          case 'U':
            y++;
            break;
          case 'D':
            y--;
            break;

        }
      }
      return x == 0 && y == 0;
    }
  }
}
