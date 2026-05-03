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
    private void dfs(TreeNode root, List<Integer> nodes, int level){
        if(root == null) return;

        if(nodes.size() < level){
            nodes.add(root.val);
        }

        dfs(root.right, nodes, level + 1);
        dfs(root.left, nodes, level + 1);
    }


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();

        if(root == null) return nodes;

        dfs(root, nodes, 1);

        return nodes;
    }
}