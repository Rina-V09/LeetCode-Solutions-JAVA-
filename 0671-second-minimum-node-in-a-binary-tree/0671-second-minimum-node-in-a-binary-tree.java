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
        SortedSet<Integer> set = new TreeSet<>();
        
        private void traverse(TreeNode root){
            if(root==null)
                return;

            set.add(root.val);
            traverse(root.left);
            traverse(root.right);
        }

    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        ArrayList<Integer> nums = new ArrayList<>();
        Iterator<Integer> it = set.iterator();
        while(it.hasNext())
            nums.add(it.next());
        return (nums.size() > 1) ? nums.get(1):-1;
    }
}