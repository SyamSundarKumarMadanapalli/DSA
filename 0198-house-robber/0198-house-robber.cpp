class Solution {
public:
    int findMaxRob(vector<int>& nums, vector<int>& dp, int ind, int size){
        if(ind >= size){
            return 0;
        }

        if(dp[ind] != -1)return dp[ind];

        int rob = nums[ind] + findMaxRob(nums, dp, ind + 2, size);
        int notRob = findMaxRob(nums, dp, ind + 1, size);

        return dp[ind] = max(rob, notRob);
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int>dp(n+1, -1);

        return findMaxRob(nums, dp, 0, n);
    }
};