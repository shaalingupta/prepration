package dsa;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      public static ListNode convert(int[] arr){
          if (arr == null || arr.length == 0) {
              return null;
          }

          ListNode dummyHead = new ListNode();
          ListNode current = dummyHead;

          for (int value : arr) {
              // Create a new node with the current value
              ListNode newNode = new ListNode(value);
              // Link the new node to the current node
              current.next = newNode;
              // Move the current pointer to the new node
              current = current.next;
          }

          // Return the head of the linked list (skip the dummy head)
          return dummyHead.next;
      }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}