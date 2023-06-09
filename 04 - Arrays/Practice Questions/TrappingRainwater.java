import java.util.*;

public class TrappingRainwater {

  // Optimal Solution TC = O(n)
  public static void trappedRainwater(int height[], int width) {

    // WL = MIN(left max, right max)
    // Trapped Water = Water Level - Current Height (if WL > CH)
    int n = height.length;
    int ch = 0, tw = 0, wl = 0;
    int leftmax[] = new int[n];
    int rightmax[] = new int[n];

    // Calculating left max array
    leftmax[0] = height[0];
    for (int i = 1; i < n; i++) {
      leftmax[i] = Math.max(height[i], leftmax[i - 1]);
    }

    // Calculating Right Max Array
    rightmax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightmax[i] = Math.max(height[i], rightmax[i + 1]);
    }

    // Calculating TW
    for (int i = 0; i < n; i++) {
      ch = height[i];
      wl = Math.min(leftmax[i], rightmax[i]);
      if (wl > ch) {
        tw += wl - ch;
      }
    }
    tw = tw * width;
    System.out.println("Trapped water = " + tw);
  }

  // Brute Force Method TC = O(n^2)
  public static void trappingRainwater(int num[], int width) {
    int w = width, maxLeftHeight = 0, maxRightHeight = 0, currentHeight = 0, volume = 0;
    int n = num.length;

    for (int i = 1; i < n - 1; i++) {
      currentHeight = num[i];
      maxLeftHeight = 0;
      maxRightHeight = 0;
      // System.out.println("currentHeight: " + currentHeight);

      // Calculting maximum height to left
      for (int j = 0; j < i; j++) {
        maxLeftHeight = Math.max(maxLeftHeight, num[j]);
        // System.out.println("maxLeftHeight: " + maxLeftHeight);
      }

      // Calculating maximum height to right
      for (int j = (i + 1); j < n; j++) {
        maxRightHeight = Math.max(maxRightHeight, num[j]);
        // System.out.println("maxRightHeight: " + maxRightHeight);

      }

      int minHeight = Math.min(maxRightHeight, maxLeftHeight);
      // System.out.println("minHeight: " + minHeight);
      if (currentHeight < minHeight) {
        volume += (minHeight - currentHeight);
        // System.out.println("volume: " + volume);
      }
      // System.out.println();
    }
    volume = volume * w;
    System.out.println("Volume of water Trapped: " + volume);
  }

  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    int arr[] = { 7, 4, 2, 0, 6, 3, 2, 5, 7 };
    int width = 1;
    trappingRainwater(arr, width);
    trappedRainwater(arr, width);

  }
}
