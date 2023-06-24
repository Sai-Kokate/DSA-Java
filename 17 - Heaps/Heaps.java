import java.util.*;

public class Heaps {
  static class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data) {

      // add at the end
      arr.add(data);

      // fix the heap
      int x = arr.size() - 1; // index of the child
      int par = (x - 1) / 2; // index of the parent

      while (arr.get(x) < arr.get(par)) {
        // swap
        int temp = arr.get(x);
        arr.set(x, arr.get(par));
        arr.set(par, temp);

        x = par;
        par = (x - 1) / 2;
      }
    }

    public int peek() {
      return arr.get(0);
    }

    public void heapify(int i) {
      int minIdx = i;
      int left = 2 * i - 1;
      int right = 2 * i + 1;
      int root = arr.get(minIdx);
      int lc = arr.get(left);
      int rc = arr.get(right);

      if (left < arr.size() && root > lc) {
        minIdx = left;
      }

      root = arr.get(minIdx);

      if (right < arr.size() && root > rc) {
        minIdx = root;
      }

      if (minIdx != i) {
        // swap
        int temp = arr.get(i);
        arr.set(i, arr.get(minIdx));
        arr.set(minIdx, temp);

        // call again for the changed index
        heapify(minIdx);
      }
    }

    public int remove() {
      int data = arr.get(0);

      // swap first and last nodes
      int temp = arr.get(0);
      arr.set(0, arr.get(arr.size() - 1));
      arr.set(arr.size() - 1, temp);

      // delete last element
      arr.remove(arr.size() - 1);

      // call heapify()
      heapify(0);

      return data;
    }

    public boolean isEmpty() {
      return arr.size() == 0;
    }
  }

  public static void main(String[] args) {
    Heap h = new Heap();
    h.add(3);
    h.add(4);
    h.add(1);
    h.add(5);

    while (!h.isEmpty()) {
      System.out.println(h.peek());
      h.remove();
    }
  }
}
