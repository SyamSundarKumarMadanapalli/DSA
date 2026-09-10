/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int ans = 0;
    pair<int, int> solve(TreeNode* root){
        if(root == nullptr) return {0, 0};

        pair<int, int> leftSubTreeSum = solve(root->left);
        pair<int, int> rightSubTreeSum = solve(root->right);

        int sum = leftSubTreeSum.first + rightSubTreeSum.first + root->val;
        int cnt = leftSubTreeSum.second + rightSubTreeSum.second + 1;

        if(sum / cnt == root->val) ans++;

        return {sum, cnt};
    }

    int averageOfSubtree(TreeNode* root) {
        solve(root);

        return ans;
    }
};