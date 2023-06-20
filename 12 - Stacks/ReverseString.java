import java.util.*;

public class ReverseString {
  public static String reverseString(String str) {
    Stack<Character> s = new Stack<>();

    while (str.length() != 0) {
      s.push(str.charAt(0));
      str = str.substring(1);
    }
    StringBuilder res = new StringBuilder("");
    while (!s.isEmpty()) {
      char ch = s.pop();
      res.append(ch);
    }

    return res.toString();

  }

  public static void main(String[] args) {
    String str = "saibalaji";

    System.out.println(reverseString(str));

  }

}
