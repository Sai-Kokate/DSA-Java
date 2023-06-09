public class SellStock {

  // Optimised Solution TC = O(n)
  public static void buyAndSellStocks(int arr[]) {
    int n = arr.length;
    int buyprice = arr[0];
    int maxprofit = 0, currentprofit = 0;

    for (int i = 1; i < n; i++) {
      if (buyprice < arr[i]) {
        currentprofit = arr[i] - buyprice;
        maxprofit = Math.max(maxprofit, currentprofit);
      } else {
        buyprice = arr[i];
      }
    }
    System.out.println("Maximum Profit: " + maxprofit);
  }

  // Brute Force Method TC = O(n^2)
  public static void sellStocks(int num[]) {
    int n = num.length, minBuy[] = new int[n], maxSell[] = new int[n], maxProfit = Integer.MIN_VALUE, profit = 0;

    minBuy[0] = num[0];
    maxSell[n - 1] = num[n - 1];

    for (int i = 1; i < n; i++) {
      minBuy[i] = Math.min(num[i], minBuy[i - 1]);
    }

    for (int i = n - 2; i >= 0; i--) {
      maxSell[i] = Math.max(num[i], maxSell[i + 1]);
    }

    for (int i = 1; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        profit = maxSell[j] - minBuy[i];
        maxProfit = Math.max(maxProfit, profit);
      }
    }

    if (maxProfit < 0)
      maxProfit = 0;

    System.out.println("Maximum Profit: " + maxProfit);
  }

  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    int arr[] = { 7, 1, 5, 3, 6, 4 };

    buyAndSellStocks(arr);
    sellStocks(arr);

  }

}
