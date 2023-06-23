
import java.util.*;

public class MininumCoins {

  public static void main(String[] args) {
    Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
    int amt = 1099;
    ArrayList<Integer> ansCoins = new ArrayList<>();
    int count = 0;

    Arrays.sort(coins, Collections.reverseOrder());

    for (int i = 0; i < coins.length; i++) {
      if (coins[i] <= amt) {
        while (coins[i] <= amt) {
          amt = amt - coins[i];
          ansCoins.add(coins[i]);
          count++;
        }
      }
      if (amt == 0) {
        break;
      }

    }

    System.out.println("Minimum Coins reuired: " + count);
    System.out.println("Coins used: " + ansCoins);
  }
}
