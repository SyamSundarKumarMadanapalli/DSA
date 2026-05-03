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
    private int dfs(TreeNode root, int maxValue){
        if(root == null) return 0;

        int newMax = Math.max(maxValue, root.val);
        int curValue = newMax > root.val ? 0 : 1;

        return curValue + dfs(root.left, newMax) + dfs(root.right, newMax);
    }


    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}