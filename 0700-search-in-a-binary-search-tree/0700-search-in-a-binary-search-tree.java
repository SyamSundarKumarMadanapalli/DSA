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
    TreeNode node = null;

    private boolean dfs(TreeNode root, int value){
        if(root == null) return false;

        if(root.val == value){
            node = root;
            return true;
        }

        if(dfs(root.left, value) || dfs(root.right, value)){
            return true;
        }

        return false;
    }

    
    public TreeNode searchBST(TreeNode root, int val) {
        dfs(root, val);
        return node;
    }
}