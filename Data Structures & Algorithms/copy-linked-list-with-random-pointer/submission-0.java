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
        if (head == null) {
            return null;
        }
        Map<Node, Node> nodes = new HashMap();
        Node dummy = new Node(0);
        Node currentCopy = dummy.next;
        Node prev = dummy;
        Node current = head;
        while(current != null) {
            currentCopy = new Node(current.val);
            prev.next = currentCopy;
            nodes.put(current, currentCopy);
            current = current.next;
            prev = currentCopy;
            currentCopy = currentCopy.next;
        }

        current = head;
        while (current != null) {
            Node copyNode = nodes.get(current);
            copyNode.random = nodes.get(current.random);
            current = current.next;
        }

        return dummy.next;
    }
}
