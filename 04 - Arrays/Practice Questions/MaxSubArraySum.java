import java.util.*;

public class MaxSubArraySum {

  // Kadane's Algorithm: TC = O(n)
  public static void kadanesAlgorithm(int num[]) {
    int n = num.length, maxsum = Integer.MIN_VALUE;
    int cs = 0;
    for (int i = 0; i < n; i++) {
      cs = cs + num[i];
      maxsum = Math.max(maxsum, cs);
      if (cs < 0) {
        cs = 0;
      }
    }

    System.out.println("Maximum subarray sum is: " + maxsum);
  }

  // Prefix Sum Method: TC = O(n^2)
  public static void prefixSumMethod(int num[]) {
    int n = num.length, maxsum = Integer.MIN_VALUE;
    int prefix[] = new int[n];
    prefix[0] = num[0];

    // Creating prefix array
    for (int i = 1; i < n; i++) {
      prefix[i] = prefix[i - 1] + num[i];
    }

    for (int i = 0; i < n; i++) {
      int start = i;
      int currsum = 0;
      for (int j = i; j < n; j++) {
        int end = j;
        currsum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
        maxsum = Math.max(maxsum, currsum);
      }
    }
    System.out.println("Maximum subarray sum is: " + maxsum);

  }

  // Brute force Method : TC = O(n^3)
  public static void maxSubArryaSum(int numbers[]) { // TC = O(n^3)
    int n = numbers.length;
    int sum = 0;
    int maxsum = Integer.MIN_VALUE;
    int current;
    int end;

    for (int i = 0; i < n; i++) {
      current = i;

      for (int j = current; j < n; j++) {
        end = j;

        for (int k = current; k <= end; k++) {
          sum += numbers[k];
        }
        maxsum = Math.max(maxsum, sum);
        sum = 0;

      }

    }
    System.out.println("Maximum subarray sum is: " + maxsum);
  }

  public static void main(String[] args) {
    // int arr[] = { 1, 6, 7, 8, 4, 2, 3, 9, 5 };
    int arr[] = { 1, -6, -7, -8, -4, -2, -3, 9, 5 };
    kadanesAlgorithm(arr);
    prefixSumMethod(arr);
    maxSubArryaSum(arr);
  }
}
