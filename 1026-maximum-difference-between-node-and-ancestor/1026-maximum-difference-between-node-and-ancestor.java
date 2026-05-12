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
    int maxValue = Integer.MIN_VALUE;

    private void dfs(TreeNode root, int maxVal, int minVal){
        if(root == null){
            return;
        }

        maxValue = Math.max(Math.abs(maxVal - root.val), maxValue);
        maxValue = Math.max(Math.abs(minVal - root.val), maxValue);
        maxVal = root.val > maxVal ? root.val : maxVal;
        minVal = root.val < minVal ? root.val : minVal;

        dfs(root.left, maxVal, minVal);
        dfs(root.right, maxVal, minVal);
    }
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return maxValue;
    }
}