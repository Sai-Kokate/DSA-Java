import java.util.*;

public class MaxLengthChainOfPairs {

  public static void main(String[] args) { // Tc = O(nlogn)
    int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

    Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

    int chainLength = 1; // first pair of sorted array is always selected
    int lastEnd = pairs[0][1];

    for (int i = 1; i < pairs.length; i++) {
      if (pairs[i][0] >= lastEnd) { // start of next >= last end
        chainLength++;
        lastEnd = pairs[i][1];
      }
    }

    System.out.println("Maximum Chain length: " + chainLength);
  }
}
