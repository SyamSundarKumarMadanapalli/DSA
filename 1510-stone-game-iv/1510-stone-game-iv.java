class Solution {
    int[] dp;
    private boolean solve(int n){
        if(n == 0) return false;

        if(dp[n] != -1) return dp[n] == 1 ? true : false;

        for(int i = 1; (i * i) <= n; i++){
            if(solve(n - (i*i)) == false){
                dp[n] = 1;
                return true;
            }
        }
        dp[n] = 0;
        return false;
    }


    public boolean winnerSquareGame(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return solve(n);
    }
}