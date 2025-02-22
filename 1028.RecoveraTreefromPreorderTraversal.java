class Solution {
    int index = 0; // Global variable to track the current position in the string
    int n = 0; // Stores the length of the traversal string

    public TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length(); // Initialize the length of the string
        return recur(traversal); // Call the recursive function to reconstruct the tree
    }

    public TreeNode recur(String traversal) {
        Stack<TreeNode> stack = new Stack<>(); // Stack to keep track of tree nodes at each depth
        
        while (index < n) {
            // Count the number of dashes to determine the depth of the current node
            int count = 0;
            while (index < n && !Character.isDigit(traversal.charAt(index))) {
                count++; // Increment count for each dash
                index++;
            }

            // Adjust stack to match the current depth
            int depth = stack.size(); 
            while (depth > count) { 
                stack.pop(); // Pop elements from the stack until it matches the required depth
                depth--;
            }

            // Extract the node value (number)
            int val = 0;
            while (index < n && Character.isDigit(traversal.charAt(index))) { // Read the number
                val = val * 10 + (traversal.charAt(index) - '0'); // Convert character to integer
                index++;
            }

            // Create a new TreeNode with the extracted value
            TreeNode node = new TreeNode(val);

            // Attach the new node as a left or right child of the previous node (if any)
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node; // Assign as left child if left is empty
                } else {
                    stack.peek().right = node; // Otherwise, assign as right child
                }
            }

            // Push the current node onto the stack to track its depth
            stack.push(node);
        }

        // The root of the tree is the bottom-most node remaining in the stack
        while (stack.size() > 1) {
            stack.pop(); // Pop all elements except the root node
        }
        return stack.peek(); // Return the root node of the reconstructed tree
    }
}
