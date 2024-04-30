package dsa;

import java.util.*;


/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is n.
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 *
 *
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 *
 */

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k){
        ListNode ptr = head;
        ListNode node = null;

        ListNode tail = null;

        while (ptr != null){
            int count = 0;
            ptr = head;

            while(count < k && ptr!=null){
                count++;
                ptr = ptr.next;
            }

            if(count == k){
                ListNode rev = reverse(head, k);

                if(node == null){
                    node = rev;
                }

                if(tail != null){
                    tail.next = rev;
                }
                tail = head;
                head = ptr;
            }
        }

        if(tail != null){
            tail.next = head;
        }

        return node == null ? head : node;
    }

    private ListNode reverse(ListNode head, int k){
        ListNode ptr = head;
        ListNode node = null;

        while(k > 0){
            ListNode temp = ptr.next;

            ptr.next = node;
            node = ptr;
            ptr = temp;
            k--;
        }
        return node;
    }

    

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode list = ListNode.convert(arr);
        ReverseNodesInKGroup kgp = new ReverseNodesInKGroup();
        ListNode res = kgp.reverseKGroup(list, 2);
        ListNode.printList(res);
    }
}
