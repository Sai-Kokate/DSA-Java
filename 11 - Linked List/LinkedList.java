public class LinkedList {

  public static class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  public static Node head;
  public static Node tail;
  public static int size;

  public void print() {
    if (head == null) {
      System.out.println("Linked List is Empty");
      return;
    }

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.println("null");
  }

  public static void addFirst(int data) {
    // create new Node
    Node newNode = new Node(data);
    size++;

    // if its the first element
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // pointing new node to current head
    newNode.next = head;

    // changing head to new node
    head = newNode;
  }

  public static void addLast(int data) {
    // create new Node
    Node newNode = new Node(data);
    size++;
    // if its the first element
    if (head == null) {
      head = tail = newNode;
      return;
    }

    // adding new node to the end
    tail.next = newNode;

    // assigning the last node to tail
    tail = newNode;

  }

  public void add(int idx, int data) {
    if (idx == 0) {
      addFirst(data);
      return;
    }

    Node newNode = new Node(data); // creating new node with the given data
    size++;
    Node temp = head; // initializing temp with fiorst element
    int i = 0; // creating an iterator
    while (i < idx - 1) {
      temp = temp.next; // moving temp to next node with each iteration
      i++;
    }

    // when loop ends temp is pointing to element previous to given index

    newNode.next = temp.next; // pointing newnode to the elemnt present at the given index currently
    temp.next = newNode; // pointing previous element to new element
  }

  public int removeFirst() {
    if (size == 0) {
      System.out.println("Linked List is Empty");
      return Integer.MIN_VALUE;
    }

    if (size == 1) {
      int value = head.data;
      head = tail = null;
      size = 0;
      return value;
    }

    int value = head.data;
    head = head.next;
    size--;
    return value;

  }

  public int removeLast() {

    if (size == 0) {
      System.out.println("Linked List is Empty");
      return Integer.MIN_VALUE;
    }

    if (size == 1) {
      int value = head.data;
      head = tail = null;
      size = 0;
      return value;
    }

    // prev -> i = size -2
    Node prev = head;
    for (int i = 0; i < size - 2; i++) {
      prev = prev.next;
    }

    int value = prev.next.data; // tail.data
    prev.next = null;
    tail = prev;
    size--;
    return value;

  }

  public int itrSearch(int key) {
    Node temp = head;
    int i = 0;

    while (temp != null) {
      if (temp.data == key) {
        return i;
      }
      i++;
      temp = temp.next;
    }

    return -1; // in case not found
  }

  public int helper(Node head, int key) {

    // base case , when head is null, the key is not found
    if (head == null) {
      return -1;
    }

    if (head.data == key) {
      return 0;
    }

    int index = helper(head.next, key); // recursive step, passing the remaining part of list

    if (index == -1) {
      return -1;
    }

    return index + 1; // will increase for each call
  }

  public int recSearch(int key) {
    return helper(head, key);
  }

  public void reverse() { // TC = O(n)
    // initialization
    Node prev = null;
    Node curr = tail = head;
    Node next;

    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    head = prev;
  }

  public void deleteNthFromEnd(int n) {
    // calculate size : sz
    int sz = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      sz++;
    }

    // if n = size , then we have to remove head
    if (n == sz) {
      head = head.next;
      return;
    }

    int iToFind = sz - n;
    int i = 1;
    Node prev = head;

    while (i < iToFind) {
      prev = prev.next;
      i++;
    }

    // we have reached at the previous element of the actual element to be removed
    prev.next = prev.next.next;

    return;
  }

  public Node findMid(Node head) { // slow and fast approach
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow; // slow is the midNode
  }

  public boolean checkPalindrome() {
    if (head == null || head.next == null) {
      return true;
    }
    // step 1 - find mid
    Node midNode = findMid(head);

    // step 2 - reverse 2nd half
    Node prev = null;
    Node curr = midNode;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node head2 = prev;
    Node head1 = head;
    // step 3 - compare both the halfs
    while (head1 != null || head2 != null) {
      if (head1.data != head2.data) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    return true;
  }

  public boolean isCycle() {
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public void removeCycle() {
    // detect Cycle
    Node slow = head;
    Node fast = head;
    boolean isCycle = false;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        isCycle = true;
        break;
      }
    }

    if (isCycle == false) {
      return;
    }
    // updating slow = head
    slow = head;
    Node prev = null; // last node
    while (slow != fast) {
      prev = fast;
      slow = slow.next; // +1
      fast = fast.next; // +1
    }

    prev.next = null; // last node
  }

  public static Node getMid(Node head) { // slow and fast approach
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow; // slow is the midNode
  }

  public static Node merge(Node leftPart, Node rightPart) {
    Node mergeLL = new Node(-1);
    Node temp = mergeLL;

    while (leftPart != null && rightPart != null) {
      if (leftPart.data < rightPart.data) {
        temp.next = leftPart;
        leftPart = leftPart.next;
      } else {
        temp.next = rightPart;
        rightPart = rightPart.next;
      }
      temp = temp.next;

    }

    while (leftPart != null) {
      temp.next = leftPart;
      leftPart = leftPart.next;
      temp = temp.next;
    }

    while (rightPart != null) {
      temp.next = rightPart;
      rightPart = rightPart.next;
      temp = temp.next;
    }

    mergeLL = mergeLL.next;
    return mergeLL;
  }

  public static Node mergeSort(Node head) {
    // base case
    if (head == null || head.next == null) {
      return head;
    }

    // find mid -> getMid
    Node midNode = getMid(head);

    // separate right and left part and call Merge Sort on both the halfs
    Node rightHead = midNode.next;
    Node leftHead = head;
    midNode.next = null;

    Node newLeft = mergeSort(leftHead);
    Node newRight = mergeSort(rightHead);

    // merge
    return merge(newLeft, newRight);
  }

  public void zigZag() {
    // get mid
    Node midNode = getMid(head);

    // reverse the 2nd part
    Node curr = midNode.next;
    midNode.next = null;
    Node prev = null;
    Node next;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    Node rightHead = prev;
    Node leftHead = head;
    Node nextLeft, nextRight;

    // alternate joining
    while (leftHead != null && rightHead != null) {
      // zig zag joining
      nextLeft = leftHead.next;
      leftHead.next = rightHead;
      nextRight = rightHead.next;
      rightHead.next = nextLeft;

      // upadte head pointers
      leftHead = nextLeft;
      rightHead = nextRight;
    }
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();

    ll.addFirst(1);
    ll.addFirst(3);
    ll.addLast(2);
    ll.addLast(4);
    ll.addLast(6);

    ll.add(2, 9);
    ll.print();

    // ll.head = mergeSort(ll.head);
    ll.zigZag();
    ll.print();

    // System.out.println(ll.checkPalindrome());
  }
}