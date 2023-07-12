// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

// There is only one repeated number in nums, return this repeated number.

// You must solve the problem without modifying the array nums and uses only constant extra space.

public class FindDuplicateNumber {

  public static int findDuplicate(int[] nums) {
    // tc = nlogn
    // Arrays.sort(nums);

    // for (int i=0; i<nums.length-1; i++){
    // if(nums[i]==nums[i+1]){
    // return nums[i];
    // }
    // }
    // return -1;

    // tc = O(n)
    int fast = nums[0];
    int slow = nums[0];

    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (fast != slow);

    fast = nums[0];
    while (fast != slow) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;

  }

  public static void main(String[] args) {
    int nums[] = { 1, 3, 4, 2, 2 };
    System.out.println(findDuplicate(nums));

  }
}
