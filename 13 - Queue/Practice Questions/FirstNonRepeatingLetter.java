import java.util.*;

public class FirstNonRepeatingLetter {

  public static void printFirstNonRepeatingLetter(String str) {
    int n = str.length();
    int freq[] = new int[26];
    String nonRepating = "";
    Queue<Character> q = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      char ch = str.charAt(i);
      q.add(ch);
      freq[ch - 'a']++;
      while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
        q.remove();
      }
      if (q.isEmpty()) {
        System.out.println("First repeating char: " + "-1");
        nonRepating += "-1";
      } else {
        System.out.println("First repeating char: " + q.peek());
        nonRepating += q.peek();
      }
    }

    System.out.println(nonRepating);
  }

  public static void main(String[] args) {
    String str = "aabccxb";

    printFirstNonRepeatingLetter(str);
  }

}
