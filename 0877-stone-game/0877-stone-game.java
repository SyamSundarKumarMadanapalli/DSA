class Solution {
    Integer[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];

        return count(piles, 0, n-1) >= 0;
    }

    public int count(int[] piles, int left, int right){
        if (left == right) return piles[left];

        if (dp[left][right] != null) return dp[left][right];

        int l = piles[left] - count(piles, left + 1, right);
        int r = piles[right] - count(piles, left, right - 1);

        return dp[left][right] = Math.max(l, r);
    }
}