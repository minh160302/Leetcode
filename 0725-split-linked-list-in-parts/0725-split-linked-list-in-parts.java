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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;            
        }
        ListNode[] res = new ListNode[k];
        int[] countIndices = new int[k];
        Arrays.fill(countIndices, count / k);
        count %= k;
        for (int i = 0; i < count; i++)
            countIndices[i]++;

        for (int i = 0; i < k; i++) {
            int listSize = countIndices[i];
            ListNode part = new ListNode();
            ListNode dumb = part;
            while (listSize > 0) {                
                dumb.next = head;
                dumb = dumb.next;
                head = head.next;
                listSize--;
            }
            dumb.next = null;
            res[i] = part.next;
        }

        return res;
    }
}