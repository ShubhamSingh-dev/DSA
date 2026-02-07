import java.util.*;

public class Q4_Square_of_sortedArray {
  public int[] sortedSquares(int[] nums) {
    //  int n = nums.length;
     List<Integer> neg = new ArrayList<>();
     List<Integer> pos = new ArrayList<>();

    //  seperate negative and positive numbers
    for(int num : nums){
        if(num < 0) 
            neg.add(num);
        else 
            pos.add(num);
    }

    //Case 1 : All positive numbers
    if(neg.size() == 0){
        for(int i=0; i < pos.size(); i++){
            pos.set(i , pos.get(i) * pos.get(i));
        }
        return pos.stream().mapToInt(Integer::intValue).toArray();
    }

    //Case 2 : All negative numbers
    if(pos.size() == 0){
        for(int i=0; i < neg.size(); i++){
            neg.set(i , neg.get(i) * neg.get(i));
        }
        Collections.reverse(neg);
        return neg.stream().mapToInt(Integer::intValue).toArray();
    }

    //Case 3 : Mixed numbers
    int i = 0, j = 0, id = 0;
    int n1 = neg.size();
    int n2 = pos.size();
    int[] res = new int[n1 + n2];

    //square negative numbers and reverse them
    for(i = 0; i < n1; i++){
        neg.set(i , neg.get(i) * neg.get(i));
    }
    Collections.reverse(neg);

    //square positive numbers
    for(j = 0; j < n2; j++){
        pos.set(j , pos.get(j) * pos.get(j));
    }

    i = 0; j = 0;
    //Merge two sorted arrays
    while(i < n1 && j < n2){
        if(neg.get(i) <= pos.get(j)){
            res[id++] = neg.get(i++);
        } else {
            res[id++] = pos.get(j++);
        }
    
    }

    //Add remaining elements
    while(i < n1){
        res[id++] = neg.get(i++);
    }

    //Add remaining elements
    while(j < n2){
        res[id++] = pos.get(j++);
    }
    return res;
   

    }

     public static int[] sortedSquares_easier(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int left = 0;
        int right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                res[pos--] = leftSq;
                left++;
            } else {
                res[pos--] = rightSq;
                right--;
            }
        }
        return res;
    }
}
