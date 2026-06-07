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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> parents = new HashSet<> ();
        Set<Integer> children = new HashSet<> ();
        Map<Integer, List<int[]>> parentChild = new HashMap<> ();

        for(int[] des: descriptions){
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            parents.add(parent);
            parents.add(child);
            children.add(child);

            parentChild
                .computeIfAbsent(parent, l -> new ArrayList<>())
                .add(new int[] {child, isLeft});
        }

        parents.removeAll(children);
        TreeNode root = new TreeNode(parents.iterator().next());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();

            for (int[] childInfo : parentChild.getOrDefault(
                parent.val,
                Collections.emptyList()
            )) {
                int childValue = childInfo[0], isLeft = childInfo[1];
                TreeNode child = new TreeNode(childValue);
                queue.offer(child);

                if (isLeft == 1) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
        }

        return root;
    }
}