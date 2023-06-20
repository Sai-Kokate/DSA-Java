import java.util.*;

public class StockSpanProblem {
  static int span = 0;
  static int maxSpan = span;

  public static void stockSpan(int stocks[], int span[]) {
    // create a new stack;
    Stack<Integer> s = new Stack<>();
    span[0] = 1;
    s.push(0); // pushing index 0 in the stack for comparison , prevHigh

    for (int i = 1; i < stocks.length; i++) {
      int currPrice = stocks[i];

      // compare if the current price is greater than vakue present at the index at
      // the top of the stack(prevHigh)
      while (currPrice > stocks[s.peek()] && !(s.isEmpty())) {
        s.pop(); // if the current price is greater , removing the index from stack , to later
                 // store the index of highest element
      }

      if (s.isEmpty()) {
        span[i] = i + 1;
      }

      else {
        int prevHigh = s.peek();
        span[i] = i - prevHigh;
      }

      s.push(i);
    }
  }

  public static void main(String[] args) {
    int stocks[] = { 100, 80, 60, 70, 60, 85, 100 };
    int span[] = new int[stocks.length];
    stockSpan(stocks, span);

    for (int i = 0; i < span.length; i++) {
      System.out.print(span[i] + " ");
    }
  }
}
