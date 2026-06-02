class Solution {
public:

    // int lis(int idx, int prevIdx, int n, vector<int> &nums, vector<vector<int>> &dp){
    //     if(idx == n){
    //         return 0;
    //     }
    //     if(dp[idx][prevIdx + 1] != -1){
    //         return dp[idx][prevIdx + 1];
    //     }
    //     int take = INT_MIN;
    //     if(idx == 0 || prevIdx == -1 || nums[idx] > nums[prevIdx]){
    //         take = 1 + lis(idx + 1, idx, n, nums, dp);
    //     }
    //     int notTake = 0 + lis(idx + 1, prevIdx, n, nums, dp);
    //     return dp[idx][prevIdx + 1] = max(take, notTake);
    // }

    // int lengthOfLIS(vector<int>& nums) {
    //     int n = nums.size();
    //     vector<vector<int>> dp(n, vector<int>(n + 1, -1));
    //     return lis(0, -1, n, nums, dp);
    // }


    int lengthOfLIS(vector<int>& nums){
        int n = nums.size();

        vector<int> dp(n, 1);
        int maxLIS = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = max(dp[i], dp[j] + 1);
                    maxLIS = max(maxLIS, dp[i]);
                }
            }
        }

        return maxLIS;
    }
};