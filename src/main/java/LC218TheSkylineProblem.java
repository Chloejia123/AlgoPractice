import java.util.ArrayList;
import java.util.List;

public class LC218TheSkylineProblem {
  class Solution {
    private int begin = 0;

    public List<int[]> getSkyline(int[][] buildings) {
      List<int[]> roofs = new ArrayList<>();
      int[] floor = {0, 0};
      roofs.add(floor);
      for (int[] building : buildings) {
        helpAdd(roofs, building);
      }
      for (int i = 0; i < roofs.size() - 1; i++) {
        int[] roof = roofs.get(i);
        int[] next = roofs.get(i + 1);
        if (roof[1] == next[1]) {
          roofs.remove(i + 1);
          i--;
        }
      }
      int[] first = roofs.get(0);
      if (first[1] == 0) {
        roofs.remove(0);
      }
      return roofs;
    }

    private void helpAdd(List<int[]> roofs, int[] bu) {
      for (int i = begin; i < roofs.size() - 1; i++) {
        int[] roof = roofs.get(i);
        int[] next = roofs.get(i + 1);
        if (roof[0] >= bu[1]) {
          break;
        }
        if (roof[1] >= bu[2] || next[0] <= bu[0]) {
          continue;
        }
        if (roof[0] < bu[0]) {
          if (next[0] <= bu[1]) {
            int[] nroof = {bu[0], bu[2]};
            roofs.add(++i, nroof);
            begin = i;
          } else {
            int[] nroof = {bu[0], bu[2]};
            int[] nroof2 = {bu[1], roof[1]};
            roofs.add(i + 1, nroof2);
            roofs.add(i + 1, nroof);
            begin = i + 1;
            break;
          }
        } else {
          if (next[0] <= bu[1]) {
            roof[1] = bu[2];
          } else {
            int[] nroof = {bu[1], roof[1]};
            roof[1] = bu[2];
            roofs.add(i + 1, nroof);
            break;
          }
        }

      }
      int[] last = roofs.get(roofs.size() - 1);
      if (last[1] < bu[2] && last[0] < bu[1]) {
        if (last[0] < bu[0]) {
          int[] nroof = {bu[0], bu[2]};
          int[] nroof2 = {bu[1], last[1]};
          roofs.add(nroof);
          roofs.add(nroof2);
          begin = roofs.size() - 2;
        } else {
          int[] nroof = {bu[1], last[1]};
          last[1] = bu[2];
          roofs.add(nroof);
        }
      }
    }
  }
}
