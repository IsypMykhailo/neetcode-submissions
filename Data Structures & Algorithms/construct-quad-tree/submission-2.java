/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node
bottomRight) { this.val = val; this.isLeaf = isLeaf; this.topLeft = topLeft; this.topRight =
topRight; this.bottomLeft = bottomLeft; this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    private int[][] prefix;
    public Node construct(int[][] grid) {
        int n = grid.length;
        prefix = new int[n + 1][n + 1];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                prefix[row + 1][col + 1] =
                    grid[row][col] + prefix[row][col + 1] + prefix[row + 1][col] - prefix[row][col];
            }
        }

        return constructRec(0, 0, n);
    }

    public Node constructRec(int startRow, int startCol, int size) {
        int sum = getSum(startRow, startCol, startRow + size - 1, startCol + size - 1);

        int area = size * size;

        if (sum == 0) {
            return new Node(false, true);
        }

        if (sum == area) {
            return new Node(true, true);
        }

        int half = size / 2;

        Node topLeft = constructRec(startRow, startCol, half);

        Node topRight = constructRec(startRow, startCol + half, half);

        Node bottomLeft = constructRec(startRow + half, startCol, half);

        Node bottomRight = constructRec(startRow + half, startCol + half, half);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private int getSum(int startRow, int startCol, int endRow, int endCol) {
        return prefix[endRow + 1][endCol + 1] - prefix[startRow][endCol + 1]
            - prefix[endRow + 1][startCol] + prefix[startRow][startCol];
    }
}