public class MaxSegmentTree {

  static int tree[];

  public static void init(int n) {
    tree = new int[n * 4];
  }

  public static void buildST(int arr[], int sti, int start, int end) { // O(n)
    if (start == end) {
      tree[sti] = arr[start];
      return;
    }
    int mid = (start + end) / 2;
    buildST(arr, (sti * 2) + 1, start, mid);
    buildST(arr, (sti * 2) + 2, mid + 1, end);
    tree[sti] = Math.max(tree[(sti * 2) + 1], tree[(sti * 2) + 2]);

  }

  public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
    if (si > qj || sj < qi) { // no overlap
      return Integer.MIN_VALUE;
    } else if (si >= qi && sj <= qj) { // complete overlap
      return tree[i];
    } else { // partial overlap
      int mid = (si + sj) / 2;
      return Math.max(getMaxUtil(2 * i + 1, si, mid, qi, qj), getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj));
    }
  }

  public static int getMax(int arr[], int qi, int qj) {
    int n = arr.length;
    return getMaxUtil(0, 0, n - 1, qi, qj);
  }

  public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
    if (idx < si || idx > sj) {
      return;
    }
    if (si == sj) {
      tree[i] = newVal;
    }

    if (si != sj) { // non leaf
      tree[i] = Math.max(tree[i], newVal);
      int mid = (si + sj) / 2;
      updateUtil(2 * i + 1, si, mid, idx, newVal);
      updateUtil(2 * i + 2, mid + 1, sj, idx, newVal);
    }
  }

  public static void update(int arr[], int idx, int newVal) {
    int n = arr.length;
    arr[idx] = newVal;

    updateUtil(0, 0, n - 1, idx, newVal);

  }

  public static void main(String[] args) {
    int arr[] = { 6, 8, -1, 2, 17, 1, 3, 2, 4 };
    int n = arr.length;
    init(n);
    buildST(arr, 0, 0, n - 1);

    for (int i = 0; i < tree.length; i++) {
      System.out.print(tree[i] + " ");
    }
    System.out.println();
    System.out.println(getMax(arr, 1, 5));
    update(arr, 1, 19);
    System.out.println(getMax(arr, 1, 5));
    for (int i = 0; i < tree.length; i++) {
      System.out.print(tree[i] + " ");
    }

  }
}
