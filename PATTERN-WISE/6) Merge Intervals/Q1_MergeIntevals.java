import java.util.*;
public class Q1_MergeIntevals {
  public int[][] merge(int[][] intervals) {
      if(intervals.length <= 1) return intervals;

      // Step 1: Sort intervals by start time
      Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

      List<int[]> result = new ArrayList<>();

      int start1 = intervals[0][0];
      int end1 = intervals[0][1];

      for (int i = 1; i < intervals.length; i++) {
        int start2 = intervals[i][0];
        int end2 = intervals[i][1];

        // Step 2: Check overlap
        if(end1 >= start2){
          // Merge intervals
          end1 = Math.max(end1, end2);
        } else {
          // No overlap → add current to result
          result.add(new int[]{start1, end1});
          start1 = start2;
          end1 = end2;
        }
      }

      // Add last interval
      result.add(new int[]{start1, end1});

      return result.toArray(new int[result.size()][]);
    }
}
