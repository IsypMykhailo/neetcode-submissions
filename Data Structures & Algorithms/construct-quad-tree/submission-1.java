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
    public Node construct(int[][] grid) {
        return constructRec(grid, 0, 0, grid.length - 1, grid.length - 1);
    }

    public Node constructRec(int[][] grid, int startCol, int startRow, int endCol, int endRow) {
        int valToCompare = grid[startRow][startCol];
        boolean isSameVal = true;
        for (int row = startRow; row <= endRow; row++) {
            for (int col = startCol; col <= endCol; col++) {
                if (grid[row][col] != valToCompare) {
                    isSameVal = false;
                    break;
                }
            }

            if (!isSameVal) {
                break;
            }
        }

        if (isSameVal) {
            return new Node(valToCompare == 1, true);
        }

        int midCol = startCol + (endCol - startCol) / 2;
        int midRow = startRow + (endRow - startRow) / 2;

        Node topLeft = constructRec(
            grid,
            startCol,
            startRow,
            midCol,
            midRow
        );

        Node topRight = constructRec(
            grid,
            midCol + 1,
            startRow,
            endCol,
            midRow
        );

        Node bottomLeft = constructRec(
            grid,
            startCol,
            midRow + 1,
            midCol,
            endRow
        );

        Node bottomRight = constructRec(
            grid,
            midCol + 1,
            midRow + 1,
            endCol,
            endRow
        );

        return new Node(
            true,
            false,
            topLeft,
            topRight,
            bottomLeft,
            bottomRight
        );
    }
}