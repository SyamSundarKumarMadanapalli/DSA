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
    private TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> mp){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);

        int eleIndex = mp.get(root.val);
        int noEle = eleIndex - inStart;
        
        root.left = constructTree(preorder, preStart + 1, preStart + noEle, inorder, inStart, eleIndex - 1, mp);
        root.right = constructTree(preorder, preStart + noEle + 1, preEnd, inorder, eleIndex + 1, inEnd, mp);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0; 
        int inEnd = inorder.length - 1;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i <= inEnd; i++){
            mp.put(inorder[i], i);
        }

        return constructTree(preorder, preStart, preEnd, inorder, inStart, inEnd, mp);
    }
}