class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int deleteFromS1 = s1.charAt(i-1) + dp[i-1][j];
                    int deleteFromS2 = s2.charAt(j-1) + dp[i][j-1];
                    dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
                }
            }
        }

        return dp[m][n];
    }
}