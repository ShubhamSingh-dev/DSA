// Question 1 : Activity Selection Problem
// You are given n activities with their start and end times. Select the maximum number of activities
// that can be peoformed by a single person, assuming that a person can only work on a single
// activity at a time. """Activities are sorted according to end time."""

import java.util.*;

public class ActivitySelection {
  public static void main(String[] args) { //TC = O(n)
    int start[] = {1, 3, 0, 5, 8, 5};
    int end[] = {2, 4, 6, 7, 9, 9};

    //end time basis sorting
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    //1st Activity
    maxAct = 1;
    ans.add(0);
    int lastEnd = end[0];

    for(int i = 1; i < end.length; i++) {
      if(start[i] >= lastEnd) {
        //activity select
        maxAct++;
        ans.add(i);
        lastEnd = end[i];
      }
  }

  System.out.println("Max Activities = " + maxAct);
  for(int i = 0; i < ans.size(); i++) {
    System.out.print("A" + ans.get(i) + " ");
  }
  System.out.println();
}
}