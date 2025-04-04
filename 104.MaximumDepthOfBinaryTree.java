class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> elementQueue = new LinkedList<>();
        elementQueue.add(root);
        int numberOfLevels = 0;

        while (!elementQueue.isEmpty()) {
            int nodeCountAtLevel = elementQueue.size();
            
            // Process all nodes at the current level
            for (int i = 0; i < nodeCountAtLevel; i++) {
                TreeNode current = elementQueue.poll();

                if (current.left != null)
                    elementQueue.add(current.left);
                if (current.right != null)
                    elementQueue.add(current.right);
            }

            // Increment level count after processing this level
            numberOfLevels++;
        }

        return numberOfLevels;
    }
}
