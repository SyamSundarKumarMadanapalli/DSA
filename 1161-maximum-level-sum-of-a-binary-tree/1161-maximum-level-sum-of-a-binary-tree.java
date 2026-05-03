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
    public int maxLevelSum(TreeNode root) {
        if(root.left == null && root.right == null) return 1;

        Queue<TreeNode> q = new LinkedList<> ();
        q.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int level = 0, ans = 1;

        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            while(size > 0){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
                size--;
            }

            level++;
            if(sum > maxSum){
                maxSum = sum;
                ans = level;
            }
        } 

        return ans;
    }
}