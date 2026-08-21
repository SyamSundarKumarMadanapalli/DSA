class Solution {
    public int n;


    // private int solve(int[] nums, int ind, int[] dp){
    //     if(ind >= n) return 0;

    //     if(dp[ind] != -1) return dp[ind];

    //     int take = nums[ind] + solve(nums, ind + 2, dp);
    //     int notTake = solve(nums, ind + 1, dp);

    //     return dp[ind] = Math.max(take, notTake);
    // }


    public int rob(int[] nums) {
        n = nums.length;
        int[] house = new int[n + 1];
        
        house[0] = 0;
        house[1] = nums[0];

        for(int i = 2; i <= n; i++){
            int take = nums[i - 1] + house[i - 2];
            int notTake = house[i - 1];

            house[i] = Math.max(take, notTake);
        } 

        return house[n];
    }
}