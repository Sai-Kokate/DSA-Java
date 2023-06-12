/*Que. There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown 
pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], 
nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For 
example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and 
become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, return the 
index of target if it is in nums, or -1 if it is not in nums.
You must write an algorithm with O(log n) runtime complexity */

import java.util.*;

public class FindInRotatedArray { // TC : O(logn)

  public static int minIndex(int num[]) {
    int n = num.length;
    int e = n - 1;
    int s = 0;

    while (s < e) {
      int mid = s + (e - s) / 2;
      if (num[mid] < num[mid - 1] && mid > 0) {
        return mid;
      } else {
        if (num[s] <= num[mid - 1] && num[mid] > num[e]) {
          s = mid + 1;
        } else {
          e = mid - 1;
        }
      }
    }
    return s;
  }

  public static int findInRotatedArray(int num[], int start, int end, int key) {
    int e = end;
    int s = start;
    int k = key;

    while (s < e) {
      int m = s + (e - s) / 2;
      if (num[m] == k) {
        return m;
      } else {
        if (num[m] > k) {
          e = e - 1;
        } else {
          s = s + 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 4, 5, 6, 7, 0, 1, 2 };
    int key = 4;
    int min = minIndex(arr);
    int res;
    // find in left sorted array
    if (arr[min] <= key && key <= arr[arr.length - 1]) {
      res = findInRotatedArray(arr, min, arr.length - 1, key);

    } else {
      // find in right sorted array
      res = findInRotatedArray(arr, 0, min, key);

    }
    System.out.println(res);

  }

}
