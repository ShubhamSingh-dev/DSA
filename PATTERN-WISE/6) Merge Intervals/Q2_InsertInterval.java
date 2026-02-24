import java.util.ArrayList;
import java.util.List;

public class Q2_InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();  
    int i = 0;
    int n = intervals.length;

    // 1️ Add all intervals that end before newInterval starts
    while (i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i]);
      i++;
    }

    // 2️ Merge overlapping intervals
    while(i < n && intervals[i][0] <= newInterval[1]) {
      newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      i++;
    }

    // 3️ Add the merged interval
    result.add(newInterval);

    // 4️ Add remaining intervals
    while(i < n) {
      result.add(intervals[i]);
      i++;
    }

    return result.toArray(new int[result.size()][]);
  }
}

/**
 * =========================================
 *            INSERT INTERVAL
 * =========================================
 *
 * Problem Breakdown:
 * - Given sorted, non-overlapping intervals.
 * - Insert a new interval.
 * - Maintain sorted order.
 * - Merge overlapping intervals if required.
 *
 * Key Observations:
 * - Intervals are already sorted.
 * - Existing intervals do not overlap.
 * - Only newInterval can create overlaps.
 * - Overlapping intervals will appear consecutively.
 *
 * --------------------------------------------------
 * Approach (Linear Scan - O(n)):
 *
 * We divide the solution into 3 logical phases:
 *
 * 1️⃣ Add intervals BEFORE overlap
 *    Condition:
 *    intervals[i][1] < newInterval[0]
 *
 *    These intervals end before newInterval starts.
 *    No overlap → directly add to result.
 *
 * 2️⃣ Merge overlapping intervals
 *    Condition:
 *    intervals[i][0] <= newInterval[1]
 *
 *    These intervals overlap with newInterval.
 *    Merge by expanding newInterval:
 *
 *    newStart = min(newInterval[0], intervals[i][0])
 *    newEnd   = max(newInterval[1], intervals[i][1])
 *
 *    Continue until no overlap remains.
 *
 * 3️⃣ Add merged newInterval
 *
 * 4️⃣ Add remaining intervals
 *    These start after newInterval ends.
 *    No overlap possible → directly add.
 *
 * --------------------------------------------------
 * Why This Works:
 * - We process intervals in sorted order.
 * - Each interval is visited exactly once.
 * - No sorting is required.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Interview Explanation (Short Version):
 * "Since intervals are already sorted and non-overlapping,
 *  I separate the problem into adding left intervals,
 *  merging overlaps, and then adding right intervals.
 *  This allows a single linear pass without sorting."
 *
 * =========================================
 */
