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
        diameter(root, 0);
        return maxDiameter;
    }

    private int diameter(TreeNode root, int height) {
        if (root == null) return 0;
        int leftHeight = diameter(root.left, height);
        int rightHeight = diameter(root.right, height);

        int diameter = leftHeight + rightHeight;
        if (diameter > maxDiameter) maxDiameter = diameter;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
