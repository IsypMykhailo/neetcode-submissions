/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int count = 0;
    private int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);

        return result;
    }

    private void inOrder(TreeNode current, int k) {
        if (current == null || count >= k) {
            return;
        }

        inOrder(current.left, k);
        count++;
        if (count == k) {
            result = current.val;
            return;
        }
        inOrder(current.right, k);
    }
}
