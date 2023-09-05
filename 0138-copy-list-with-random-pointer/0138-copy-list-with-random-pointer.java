/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node res = new Node(-1);
        Node p = res;
        while (head != null) {
            Node copyHead = map.getOrDefault(head, new Node(head.val));
            if (head.next != null) {
                Node copyNext = map.getOrDefault(head.next, new Node(head.next.val));
                copyHead.next = copyNext;
                map.put(head.next, copyNext);
            }
            if (head.random != null) {
                if (head.random == head)
                    copyHead.random = copyHead;
                else {
                    Node copyRandom = map.getOrDefault(head.random, new Node(head.random.val));
                    copyHead.random = copyRandom;
                    map.put(head.random, copyRandom);
                }
            }
            map.put(head, copyHead);
            p.next = copyHead;
            p = p.next;
            head = head.next;
        }
        return res.next;
    }
}