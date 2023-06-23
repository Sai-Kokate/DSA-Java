import java.util.*;

public class ActivitySelection {

  public static void main(String[] args) {
    int start[] = { 1, 3, 0, 5, 8, 5 };
    int end[] = { 2, 4, 6, 7, 9, 9 }; // end time sorted

    int activities[][] = new int[start.length][3];

    for (int i = 0; i < activities.length; i++) {
      activities[i][0] = i;
      activities[i][1] = start[i];
      activities[i][2] = end[i];
    }

    // Sorting @D array
    Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

    ArrayList<Integer> act = new ArrayList<>();
    int maxAct = 1;
    act.add(activities[0][0]); // index of the top row
    int lastend = activities[0][2];
    for (int i = 1; i < end.length; i++) {
      // check start time is less than previous activity's end time
      if (activities[i][1] >= lastend) {
        act.add(activities[i][0]);
        maxAct++;
        lastend = activities[i][2];
      }
    }
    for (int i = 0; i < act.size(); i++) {
      System.out.print("A" + act.get(i) + " ");
    }

    System.out.println("\nTotal activities: " + maxAct);
  }
}