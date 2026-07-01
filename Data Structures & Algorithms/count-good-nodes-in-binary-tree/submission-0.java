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
    private int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        searchGoodNodes(root, Integer.MIN_VALUE);

        return goodNodes;
    }

    public void searchGoodNodes(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) goodNodes++;

        int newMax = Math.max(max, root.val);

        searchGoodNodes(root.left, newMax);
        searchGoodNodes(root.right, newMax);
    }
}
