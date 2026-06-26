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

public class Codec {
    private StringBuilder serializeResult;
    private int deserializeIdx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeResult = new StringBuilder();
        preOrderSerialize(root);
        return serializeResult.toString();
    }

    private void preOrderSerialize(TreeNode root) {
        if (root == null) {
            serializeResult.append("N,");
            return;
        }

        serializeResult.append(root.val + ",");
        preOrderSerialize(root.left);
        preOrderSerialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        deserializeIdx = 0;
        String[] dataArr = data.split(",");

        return preOrderDeserialize(dataArr);
    }

    private TreeNode preOrderDeserialize(String[] vals) {
        if (vals[deserializeIdx].equals("N")) {
            deserializeIdx++;
            return null;
        }

        int val = Integer.parseInt(vals[deserializeIdx]);
        deserializeIdx++;

        TreeNode root = new TreeNode(val);

        root.left = preOrderDeserialize(vals);
        root.right = preOrderDeserialize(vals);

        return root;
    }
}
