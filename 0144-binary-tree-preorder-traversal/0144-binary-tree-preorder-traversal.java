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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l1 = new ArrayList<>();
        if(root == null){
            return l1;
        }
        l1.add(root.val);
        if(root.left!=null){
            l1.addAll(preorderTraversal(root.left));
        }
        if(root.right!=null){
            l1.addAll(preorderTraversal(root.right));
        }
        return l1;
    }
}