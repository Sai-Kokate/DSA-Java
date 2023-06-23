import java.util.*;

public class FractionalKnapsack {

  public static void main(String[] args) {
    int value[] = { 60, 100, 120 };
    int weight[] = { 10, 20, 30 };
    int W = 50;
    double capacity = W;
    double finalVal = 0;

    double ratio[][] = new double[value.length][4];

    for (int i = 0; i < ratio.length; i++) {
      ratio[i][0] = i;
      ratio[i][1] = value[i];
      ratio[i][2] = weight[i];
      ratio[i][3] = value[i] / (double) weight[i];
    }

    // sorting 2D array
    Arrays.sort(ratio, Comparator.comparingDouble(o -> o[3]));

    for (int i = (ratio.length - 1); i >= 0; i--) {
      if (capacity > 0 && ratio[i][2] <= capacity) { // wieght of the item less that remaining weight
        finalVal = finalVal + ratio[i][1]; // adding the value of the whole item to finalVal
        capacity = capacity - ratio[i][2]; // reducing the weight value as the item is added to bag
      } else {
        finalVal = finalVal + ratio[i][3] * capacity; // remaining capacity * value of next item;
        capacity = 0;
        break; // the bag is full
      }
    }

    System.out.println("Final Value: " + finalVal);
  }
}
