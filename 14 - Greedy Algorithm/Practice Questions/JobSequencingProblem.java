import java.util.*;

public class JobSequencingProblem {
  static class Job {
    int id;
    int deadline;
    int profit;

    public Job(int i, int d, int p) {
      this.id = i;
      this.deadline = d;
      this.profit = p;
    }

  }

  public static void main(String[] args) {

    int jobInfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

    ArrayList<Job> jobs = new ArrayList<>();

    for (int i = 0; i < jobInfo.length; i++) {
      jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
    }

    // Sorting ArrayList of objects of type Job
    Collections.sort(jobs, (a, b) -> b.profit - a.profit); // descending order

    ArrayList<Integer> seq = new ArrayList<>();
    int time = 0;

    for (int i = 0; i < jobs.size(); i++) {
      if (jobs.get(i).deadline > time) {
        seq.add(jobs.get(i).id);
        time++;
      }
    }

    System.out.println("Max jobs : " + seq.size());
    System.out.println("Sequence of Jobs done: " + seq);
  }
}
