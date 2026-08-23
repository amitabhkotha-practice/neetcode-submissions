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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;

        ListNode slow = head, fast = head;
        int count = 0;

        while(fast != null) {
            count++;
            fast = fast.next;
        }

        if(count == n)
            return head.next;

        int k = count - n;
        for(int i = 0; i < k - 1; i++) {
            slow = slow.next;
        }

        ListNode node = slow.next;
        slow.next = node.next;

        return head;
    }
}
