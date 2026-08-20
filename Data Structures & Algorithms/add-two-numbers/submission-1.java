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
        ListNode dummy = new ListNode(-1);
        ListNode c1 = l1, c2 = l2;
        ListNode curr = dummy;
        int carry = 0;
        while (c1 != null && c2 != null) {
            int num = c1.val + c2.val + carry;
            carry = num / 10;
            num %= 10;

            ListNode temp = new ListNode(num);
            curr.next = temp;
            curr = curr.next;

            c1 = c1.next;
            c2 = c2.next;
        }

        while (c1 != null) {
            if (carry > 0) {
                int num = c1.val + carry;
                carry = num / 10;
                num = num % 10;
                ListNode temp = new ListNode(num);
                curr.next = temp;
                curr = curr.next;
            } else {
                curr.next = c1;
                break;
            }
            c1 = c1.next;
        }

        while (c2 != null) {
            if (carry > 0) {
                int num = c2.val + carry;
                carry = num / 10;
                num = num % 10;
                ListNode temp = new ListNode(num);
                curr.next = temp;
                curr = curr.next;
            } else {
                curr.next = c2;
                break;
            }
            c2 = c2.next;
        }

        if (carry > 0) {
            ListNode temp = new ListNode(carry);
            curr.next = temp;
            curr = curr.next;
        }

        return dummy.next;
    }
}
