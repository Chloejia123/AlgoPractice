import java.util.Arrays;
import java.util.PriorityQueue;

public class LC253MeetingRoomII {
  class Solution {
    public int minMeetingRooms(Interval[] intervals) {
      if (intervals == null || intervals.length == 0) return 0;
      Arrays.sort(intervals, (a, b) -> a.start - b.start); // use of lambda
      PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end); // use of lambda
      pq.add(intervals[0]);
      // This priority queue only maintains conflict meeting
      for (int i = 1; i < intervals.length; i++) {
        if (intervals[i].start >= pq.peek().end) {
          pq.poll();
        }
        pq.offer(intervals[i]);
      }
      return pq.size(); // return the number of conflicted meetings, that's the number of rooms
      // required to book
    }
  }

  class Interval {
    int start;
    int end;

    Interval() {
      start = 0;
      end = 0;
    }

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }
}
