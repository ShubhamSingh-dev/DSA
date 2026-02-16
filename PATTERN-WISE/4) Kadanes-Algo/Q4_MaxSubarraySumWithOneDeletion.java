public class Q4_MaxSubarraySumWithOneDeletion {
   public int maximumSum(int[] arr) {
        int n = arr.length;

        int noDeletion = arr[0];
        int oneDeletion = 0;   // represents dp with one deletion
        int result = arr[0];

        for (int i = 1; i < n; i++) {

            int prevNoDeletion = noDeletion;

            // Standard Kadane
            noDeletion = Math.max(arr[i], noDeletion + arr[i]);

            // One deletion case
            oneDeletion = Math.max(oneDeletion + arr[i], prevNoDeletion);

            result = Math.max(result, Math.max(noDeletion, oneDeletion));
        }

        return result;
    }
}
