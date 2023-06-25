import java.util.*;

public class FindItinerary {

  public static String getStart(HashMap<String, String> tickets) {
    HashMap<String, String> revMap = new HashMap<>();

    for (String ticket : tickets.keySet()) {
      revMap.put(tickets.get(ticket), ticket);
    }

    for (String ticket : tickets.keySet()) {
      if (!revMap.containsKey(ticket)) {
        return ticket;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    HashMap<String, String> tickets = new HashMap<>();
    tickets.put("Chennai", "Bengaluru");
    tickets.put("Mumbai", "Delhi");
    tickets.put("Goa", "Chennai");
    tickets.put("Delhi", "Goa");
    String start = getStart(tickets);
    System.out.print(start);

    // print itinerary
    for (String key : tickets.keySet()) {
      System.out.print("->" + tickets.get(start));
      start = tickets.get(start);
    }
  }
}
