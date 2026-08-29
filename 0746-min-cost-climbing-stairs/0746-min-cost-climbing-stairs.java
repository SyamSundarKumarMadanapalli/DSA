class Solution {
    private int solve(int index, int[] cost, int[] dp){
        if(index >= cost.length) return 0;

        if(dp[index] != -1) return dp[index];

        int oneStep = cost[index] + solve(index + 1, cost, dp);
        int twoSteps = cost[index] + solve(index + 2, cost, dp);

        return dp[index] = Math.min(oneStep, twoSteps);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }

    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] first = new int[n];
    //     Arrays.fill(first, Integer.MAX_VALUE);
    //     int[] second = new int[n];
    //     Arrays.fill(second, Integer.MAX_VALUE);
    //     first[0] = cost[0];

    //     for(int i = 1; i < n; i++){
    //         int oneStep = cost[i] + first[i - 1];
    //         int twoSteps = Integer.MAX_VALUE;

    //         if(i > 1){
    //             twoSteps = cost[i] + first[i - 2];
    //         }

    //         first[i] = Math.min(oneStep, twoSteps);
    //     }

    //     second[1] = cost[1];
    //     for(int i = 2; i < n; i++){
    //         int oneStep = cost[i] + second[i - 1];
    //         int twoSteps = Integer.MAX_VALUE;

    //         if(i > 2){
    //             twoSteps = cost[i] + second[i - 2];
    //         }

    //         second[i] = Math.min(oneStep, twoSteps);
    //     }

    //     return Math.min(Math.min(first[n-1], first[n-2]), Math.min(second[n-1], second[n-2]));
    // }
}