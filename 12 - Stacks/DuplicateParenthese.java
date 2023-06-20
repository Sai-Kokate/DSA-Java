import java.util.Stack;

public class DuplicateParenthese { // TC = O(n)

  public static boolean isDuplicate(String str) {
    Stack<Character> s = new Stack<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      // closing
      if (ch == ')') {
        int count = 0;
        while (!s.isEmpty() && s.peek() != '(') {
          s.pop();
          count++;
        }
        if (count < 1) {
          return true; // duplicate parentheses found
        } else {
          s.pop(); // opening pair found
        }
      } else {
        s.push(ch); // opening bracket
      }

    }

    return false;
  }

  public static void main(String[] args) {
    String str1 = "((a+b)+(c+d))";
    String str2 = "(((a+b))+(c+d))";

    System.out.println(isDuplicate(str1));
    System.out.println(isDuplicate(str2));

  }
}
