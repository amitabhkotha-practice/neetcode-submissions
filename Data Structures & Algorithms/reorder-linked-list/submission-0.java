/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // Find Mid point
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break mid point Reverse list from mid point
        ListNode curr = slow.next;
        ListNode prev = slow.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Alternating merge reverse list and original list
        curr = head;
        ListNode curr2 = prev;

        while(curr2 != null) {
            ListNode next = curr.next;
            ListNode next2 = curr2.next;
                        
            curr.next = curr2;
            curr2.next = next;

            curr = next;
            curr2 = next2;
        }

    }
}

/*
0 1 2 3 4 5 6
0 1 2 3
6 5 4
*/
