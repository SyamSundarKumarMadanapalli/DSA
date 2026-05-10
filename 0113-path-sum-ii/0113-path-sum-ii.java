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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    private void dfs(TreeNode root, int targetSum, int sum){
        if(root == null) return;

        path.add(root.val);
        sum += root.val;

        if(sum == targetSum && root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);

        path.remove(path.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum = 0;  
        dfs(root, targetSum, sum);

        return ans;
    }
}