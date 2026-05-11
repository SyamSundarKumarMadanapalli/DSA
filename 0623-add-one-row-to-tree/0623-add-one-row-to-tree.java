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
    private void dfs(TreeNode root, int val, int depth, int treeDepth){
        if(root == null) return;

        if(treeDepth + 1 < depth){
            dfs(root.left, val, depth, treeDepth + 1);
            dfs(root.right, val, depth, treeDepth + 1);

            return;
        }

        TreeNode leftTree = new TreeNode(val);
        leftTree.left = root.left;
        root.left = leftTree;

        TreeNode rightTree = new TreeNode(val);
        rightTree.right = root.right;
        root.right = rightTree;

        return;
    }


    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        dfs(root, val, depth, 1);

        return root;
    }
}