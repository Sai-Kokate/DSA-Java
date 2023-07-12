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
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    if (i >= 0) {
      int j = nums.length - 1;
      while (j > i && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }

    reverse(nums, i + 1, nums.length - 1);
  }

  public static void main(String[] args) {
    int arr[] = { 1, 5, 1 }; // 511
    print(arr);
    nextPermutation(arr);
    print(arr);
  }
}
