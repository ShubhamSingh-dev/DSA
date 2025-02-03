// Question 1 : Activity Selection Problem
// You are given n activities with their start and end times. Select the maximum number of activities
// that can be peoformed by a single person, assuming that a person can only work on a single
// activity at a time. 

import java.util.*;

public class ActivitySelection_2 {
  public static void main(String[] args) { //TC = O(nlogn)
    int start[] = {1, 3, 0, 5, 8, 5};
    int end[] = {2, 4, 6, 7, 9, 9};

    //sorting if not sorted already
    int activities[][] = new int[start.length][3];

    for(int i = 0; i < start.length; i++) {
      activities[i][0] = i ;
      activities[i][1] = start[i];
      activities[i][2] = end[i];
    }

    //lambda function --> shortform
    Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));

    //end time basis sorting
    int maxAct = 0;
    ArrayList<Integer> ans = new ArrayList<>();

    //1st Activity
    maxAct = 1;
    ans.add(activities[0][0]);
    int lastEnd = activities[0][2];

    for(int i = 1; i < end.length; i++) {
      if(activities[i][1] >= lastEnd) {
        //activity select
        maxAct++;
        ans.add(activities[i][0]);
        lastEnd = activities[i][2];
      }
  }

  System.out.println("Max Activities = " + maxAct);
  for(int i = 0; i < ans.size(); i++) {
    System.out.print("A" + ans.get(i) + " ");
  }
  System.out.println();
}
}


// read Comparator in java pdfto understand the sorting part 