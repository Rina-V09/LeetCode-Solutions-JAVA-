class Solution {
    // Main method to find the Lowest Common Ancestor of Deepest Leaves
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Call helper method and return the resulting node
        TreeNode result = helper(root).node;
        return result;
    }

    // Helper class to store both the TreeNode and its depth
    private class Result {
        TreeNode node; // Node representing the LCA at current level
        int depth;     // Depth of the deepest leaf from this node

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // Recursive helper function to calculate LCA and depth
    private Result helper(TreeNode root) {
        // Base case: if the node is null, return null node and depth 0
        if (root == null) return new Result(null, 0);

        // Recursively get results for left and right subtrees
        Result left = helper(root.left);
        Result right = helper(root.right);

        // If both left and right subtrees have the same depth,
        // current node is the LCA of the deepest leaves
        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        }
        // If left subtree is deeper, return its node and updated depth
        else if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        }
        // If right subtree is deeper, return its node and updated depth
        else {
            return new Result(right.node, right.depth + 1);
        }
    }
}
