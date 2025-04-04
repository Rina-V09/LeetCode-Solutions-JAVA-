public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        findLeaves(root1, l1);
        findLeaves(root2, l2);

        return l1.equals(l2);
    }

    public void findLeaves(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            list.add(root.val);

        findLeaves(root.left, list);
        findLeaves(root.right, list);
    }
}
