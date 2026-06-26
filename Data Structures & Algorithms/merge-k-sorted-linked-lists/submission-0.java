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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int i = 0; i < lists.length; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                queue.add(cur.val);
                cur = cur.next;
            }
        }

        ListNode head = new ListNode();
        ListNode cur = head;

        while (!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.poll());
            cur.next = newNode;
            cur = cur.next;
        }

        return head.next;
    }
}
