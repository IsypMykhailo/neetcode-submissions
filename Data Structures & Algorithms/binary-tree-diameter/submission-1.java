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
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return maxDiameter;
    }

    private int diameter(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);

        int diameter = leftHeight + rightHeight;
        if (diameter > maxDiameter) maxDiameter = diameter;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
