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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        TreeNode l = root;
        TreeNode r = root;
        int leftHeight = 0;
        int rightHeight = 0;

        while(l != null){
            leftHeight++;
            l = l.left;
        }

        while(r != null){
            rightHeight++;
            r = r.right;
        }

        if(leftHeight == rightHeight){
            return (1 << leftHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}