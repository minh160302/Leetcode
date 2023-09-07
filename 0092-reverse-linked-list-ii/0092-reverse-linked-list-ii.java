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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode dumb = res;
        for (int i = 0; i < left - 1; i++) {
            dumb = dumb.next;
        }

        ListNode rhead = dumb;
        dumb = dumb.next;
        ListNode rtail = dumb;
        ListNode next = null;
        
        for (int i = left; i <= right; i++) {
            next = dumb.next;
            dumb.next = rhead.next;
            rhead.next = dumb;
            dumb = next;
        }
        
        // System.gc();
        rtail.next = dumb;
        return res.next;
    }
}