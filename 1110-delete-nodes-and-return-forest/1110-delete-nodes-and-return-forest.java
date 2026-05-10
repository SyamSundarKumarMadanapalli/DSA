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
    private TreeNode dfs(TreeNode root, Set<Integer> deleteNodes, List<TreeNode> forest){
        if(root == null) return null;

        root.left = dfs(root.left, deleteNodes, forest);
        root.right = dfs(root.right, deleteNodes, forest);

        if(deleteNodes.contains(root.val)){
            if(root.left != null) forest.add(root.left);

            if(root.right != null) forest.add(root.right);

            return null;
        }

        return root;
    }


    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) return null;
        if(to_delete.length == 0) return List.of(root);
        
        Set<Integer> deleteNodes = new HashSet<>();
        for(int num : to_delete){
            deleteNodes.add(num);
        }

        List<TreeNode> forest = new ArrayList<>();
        TreeNode rootMain = dfs(root, deleteNodes, forest);
        if(rootMain != null){
            forest.add(rootMain);
        }

        return forest;
    }
}