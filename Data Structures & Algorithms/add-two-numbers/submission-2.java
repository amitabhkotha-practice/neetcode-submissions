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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2;
        ListNode curr = dummy;
        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
           
            int v1 = c1 != null ? c1.val : 0;
            int v2 = c2 != null ? c2.val : 0;
            
            int num = v1 + v2 + carry;
            carry = num / 10;
            num %= 10;

            curr.next = new ListNode(num);
            curr = curr.next;

            c1 = c1 == null ? null : c1.next;
            c2 = c2 == null ? null : c2.next;
        }

        return dummy.next;
    }
}
