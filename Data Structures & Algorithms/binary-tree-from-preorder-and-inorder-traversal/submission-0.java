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
    private int preorderIndex = 0;
    private Map<Integer, Integer> indices = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indices.put(inorder[i], i);
        }

        return buildTreeRec(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRec(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootVal = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = indices.get(rootVal);

        root.left = buildTreeRec(preorder, left, inorderIndex - 1);
        root.right = buildTreeRec(preorder, inorderIndex + 1, right);

        return root;
    }
}
