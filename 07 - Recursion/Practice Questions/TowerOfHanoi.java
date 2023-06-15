// TOWER OF HANOI (Important!)
// You have 3 towers and N disks of different sizes which can slide onto any tower. The puzzle
// starts with disks sorted in ascending order of size from top to bottom (i.e., each disk sits on
// top of an even larger one).
// You have the following constraints:
// (1) Only one disk can be moved at a time.
// (2) A disk is slid off the top of one tower onto another tower.
// (3) A disk cannot be placed on top of a smaller disk. Write a program to move the disks from
// the first tower to the
// last using Stacks.

public class TowerOfHanoi {

  public static void towerOfHanoi(int n, String source, String helper, String destination) {
    // base case
    if (n == 1) {
      System.out.println("Transfering disc " + n + " from source " + source + " to destiation " + destination
          + " using helper " + helper);
      return;
    }
    // transfer top n-1 from src to helper using dest as 'helper'
    towerOfHanoi(n - 1, source, destination, helper);

    // transfer nth from src to dest
    System.out.println("Transfering disc " + n + " from source " + source + " to destiation " + destination
        + " using helper " + helper);

    // transfer n-1 from helper to dest using src as 'helper'
    towerOfHanoi(n - 1, helper, source, destination);

  }

  public static void main(String[] args) {

    int n = 3;
    towerOfHanoi(n, "A", "B", "C");
  }
}
