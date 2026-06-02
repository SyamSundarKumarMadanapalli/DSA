class Solution {
public:
    int n;

    long long maxAlternatingSum(vector<int>& nums) {
        n = nums.size();
        vector<vector<long long>> memo(n, vector<long long>(2, -1));

        return solve(nums, 0, true, memo);
    }


    long long solve(vector<int> &nums, int index, bool isEven, vector<vector<long long>> &memo){
        if(index >= n) return 0;

        if(memo[index][isEven ? 0 : 1] != -1){
            return memo[index][isEven ? 0 : 1];
        }

        long long take = isEven ? nums[index] : -nums[index];
        take += solve(nums, index + 1, !isEven, memo);

        long long notTake = solve(nums, index + 1, isEven, memo);

        return memo[index][isEven ? 0 : 1] = max(take, notTake);
    }
};