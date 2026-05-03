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
    int ans = 0;

    private void dfs(TreeNode node, boolean goLeft, int len){
        if(node == null) return;

        ans = Math.max(ans, len);

        if(goLeft){
            dfs(node.left, false, len + 1);
            dfs(node.right, true, 1);
        }else{
            dfs(node.right, true, len + 1);
            dfs(node.left, false, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;

        dfs(root.left, false, 1);
        dfs(root.right, true, 1);

        return ans;
    }
}