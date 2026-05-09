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
    private int count(TreeNode root){
        if(root == null) return 0;

        return 1 + count(root.left) + count(root.right);
    }

    private boolean dfs(TreeNode root, int i, int cnt){
        if(root == null){
            return true;
        }

        if(i > cnt){
            return false;
        }

        return dfs(root.left, 2*i,cnt) && dfs(root.right, 2*i + 1, cnt);
    }

    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;

        int cnt = count(root);

        return dfs(root, 1, cnt);
    }
}