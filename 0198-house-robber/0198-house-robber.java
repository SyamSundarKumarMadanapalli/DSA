class Solution {
    public int n;


    private int solve(int[] nums, int ind, int[] dp){
        if(ind >= n) return 0;

        if(dp[ind] != -1) return dp[ind];

        int take = nums[ind] + solve(nums, ind + 2, dp);
        int notTake = solve(nums, ind + 1, dp);

        return dp[ind] = Math.max(take, notTake);
    }


    public int rob(int[] nums) {
        n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(nums, 0, dp);
    }
}