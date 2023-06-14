// Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.

public class FriendsPairingProblem {

  public static int countWays(int n) {
    // basecase
    if (n <= 2) {
      return n;
    }

    // choices
    // 1. stand alone , remaining people to pair: n-1
    int sa = countWays(n - 1);

    // 2. pair up with any one of the n-1 people , remaining people to pair : n-2
    int pair = (n - 1) * countWays(n - 2);

    int totalWays = sa + pair;

    return totalWays;

  }

  public static void main(String[] args) {
    int n = 10;
    System.out.println(countWays(n));
  }
}
