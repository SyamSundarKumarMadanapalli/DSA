class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i<= m; i++){
            for(int j= 1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }


        return dp[m][n];

        // for (int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return solve(word1, word2, dp, 0, 0);
    }

    private int solve(String word1, String word2, int[][] dp, int l1, int l2) {
        if (word1.length() == l1)
            return word2.length() - l2;
        if (word2.length() == l2)
            return word1.length() - l1;

        if (dp[l1][l2] != -1)
            return dp[l1][l2];

        if (word1.charAt(l1) == word2.charAt(l2))
            return dp[l1][l2] = solve(word1, word2, dp, l1 + 1, l2 + 1);

        int deleteFromWord1 = 1 + solve(word1, word2, dp, l1 + 1, l2);
        int deleteFromWord2 = 1 + solve(word1, word2, dp, l1, l2 + 1);

        return dp[l1][l2] = Math.min(deleteFromWord1, deleteFromWord2);
    }
}