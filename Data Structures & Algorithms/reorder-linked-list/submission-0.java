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
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode cur = secondHalf;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode reversed = prev;

        ListNode firstHalf = head;

        while (reversed != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = reversed.next;

            firstHalf.next = reversed;
            reversed.next = temp1;

            firstHalf = temp1;
            reversed = temp2;
        }
    }
}
