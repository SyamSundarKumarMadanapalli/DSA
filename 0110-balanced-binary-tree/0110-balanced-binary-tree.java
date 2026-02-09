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
    public int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int lh = checkHeight(root.left);
        if(lh == -1)return -1;

        int rh = checkHeight(root.right);
        if(rh == -1)return -1;

        return Math.abs(lh - rh) > 1 ? -1 : Math.max(lh, rh)+1;
    }

    public boolean isBalanced(TreeNode root) {
        if(checkHeight(root) != -1){
            return true;
        }
        return false;
    }
}