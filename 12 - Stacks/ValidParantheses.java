import java.util.Stack;

public class ValidParantheses {

  public static boolean isValid(String str) {
    Stack<Character> s = new Stack<>();

    if (str.charAt(0) == ']' || str.charAt(0) == ')' || str.charAt(0) == '}') {
      return false;
    }

    s.push(str.charAt(0));

    for (int i = 1; i < str.length(); i++) {
      char currChar = str.charAt(i);
      if (currChar == '(' || currChar == '{' || currChar == '[') {
        s.push(currChar);
      } else if (currChar == ')') {
        if (!s.isEmpty() && s.peek() == '(') {
          s.pop();
        } else {
          return false;
        }
      } else if (currChar == ']') {
        if (!s.isEmpty() && s.peek() == '[') {
          s.pop();
        } else {
          return false;
        }
      } else if (currChar == '}') {
        if (!s.isEmpty() && s.peek() == '{') {
          s.pop();
        } else {
          return false;
        }
      }
    }

    if (s.isEmpty()) {
      return true;
    } else {
      return false;
    }

  }

  public static void main(String[] args) {
    String str = "[]({[]}())()";

    System.out.println(isValid(str));
  }
}
