class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, costs, dp, 0);
    }

    private int solve(int n, int[] costs, int[] dp, int index) {
        if (index == n) {
            return 0;
        }

        if (dp[index] != -1) return dp[index];

        int ans = Integer.MAX_VALUE;

        if (index + 1 <= n) {
            int costNext = costs[index];
            ans = Math.min(ans, solve(n, costs, dp, index + 1) + costNext + 1);
        }

        if (index + 2 <= n) {
            int costNext = costs[index + 1];
            ans = Math.min(ans, solve(n, costs, dp, index + 2) + costNext + 4);
        }

        if (index + 3 <= n) {
            int costNext = costs[index + 2];
            ans = Math.min(ans, solve(n, costs, dp, index + 3) + costNext + 9);
        }

        return dp[index] = ans;
    }
}