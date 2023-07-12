public class NextPermutation {
  public static void print(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swap(nums, i++, j--);
    }
  }

  public static void nextPermutation(int[] nums) {
    if (nums.length == 1 || nums.length == 0) {
      return;
    }
    
    int i = nums.length - 2;
    
    // step 1 - start from end and check at what index the increasing order breaks , nums[i]
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    // step 2,3 - if the breakpoint is found , between the breakpoint and end of array find index (j) of element whose value is greater than nums[i] and swap nums[i] and nums[j] 
    if (i >= 0) {
      int j = nums.length - 1;
      while (j > i && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }

    // step 4 - reverse the array from i+1 -> n-1
    reverse(nums, i + 1, nums.length - 1);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 5, 1 }; // 511
    print(arr);
    nextPermutation(arr);
    print(arr);
  }
}
