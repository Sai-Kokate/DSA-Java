public class SortColors01and2s {

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

  public static void sortColors(int[] nums) {
    int n = nums.length;

    // Using extra space
    // int col[] = new int[3]; // 0, 1, 2

    // for (int i = 0; i < n; i++) {
    // col[nums[i]]++;
    // }
    // int i = 0;
    // int j = 0;
    // while (i < n) {
    // while (col[j] > 0) {
    // nums[i] = j;
    // col[j]--;
    // i++;
    // }
    // j++;
    // }

    // Optimal Solution
    // No extra space used, in-place sorting

    int l = 0, r = n - 1, i = 0;

    while (i <= r) {
      if (nums[i] == 0) {
        swap(nums, i++, l++);
      } else if (nums[i] == 2) {
        swap(nums, i, r--);
      } else {
        i++;
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = { 1, 1, 0, 0, 2, 2, 1, 2, 0, 0, 2, 1, 0 };
    print(arr);
    sortColors(arr);
    System.out.println("Sorted Array:");
    print(arr);

  }
}
