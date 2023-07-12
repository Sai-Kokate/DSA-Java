
public class Merge2Arrays {
  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");

    }
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    // int newarr[] = new int[m];

    // for(int i=0; i<m; i++){
    // newarr[i] = nums1[i];
    // }

    // int i=0; int j=0; int k=0;
    // while(i<m && j<n){
    // if(newarr[i]<=nums2[j]){
    // nums1[k] = newarr[i];
    // i++;
    // k++;
    // } else {
    // nums1[k] = nums2[j];
    // j++;
    // k++;
    // }
    // }

    // while(i<m){
    // nums1[k] = newarr[i];
    // i++;
    // k++;
    // }

    // while(j<n){
    // nums1[k] = nums2[j];
    // j++;
    // k++;
    // }

    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;

    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) {
        nums1[k--] = nums1[i--];
      } else {
        nums1[k--] = nums2[j--];
      }
    }
  }

  public static void main(String[] args) {

    int nums1[] = { 1, 2, 3, 0, 0, 0 }, m = 3, nums2[] = { 2, 5, 6 }, n = 3;
    merge(nums1, m, nums2, m);
    print(nums1);

  }
}
