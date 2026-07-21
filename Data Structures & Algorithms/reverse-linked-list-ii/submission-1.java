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
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode beforeNode = dummy;
        for (int i = 1; i < left; i++) {
            beforeNode = beforeNode.next;
        }
        ListNode startNode = beforeNode.next;
        ListNode prev = null;
        ListNode cur = startNode;
        for (int i = left; i <= right; i++) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        beforeNode.next = prev;
        startNode.next = cur;

        return dummy.next;
    }
}