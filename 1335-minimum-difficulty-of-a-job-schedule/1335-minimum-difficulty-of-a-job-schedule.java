class Solution {
    private int solve(int[] jobDifficulty, int n, int idx, int d, int[][] memo){
        if(d == 1){
            int maxEle = jobDifficulty[idx];
            for(int i = idx; i < n; i++){
                maxEle = Math.max(maxEle, jobDifficulty[i]);
            }

            return memo[idx][d] = maxEle;
        }

        if(memo[idx][d] != -1) return memo[idx][d];
        
        int maxEle = jobDifficulty[idx];
        int finalResult = Integer.MAX_VALUE;
        for(int i = idx; i <= n - d; i++){
            maxEle = Math.max(maxEle, jobDifficulty[i]);
            int result = maxEle + solve(jobDifficulty, n, i + 1, d - 1, memo);

            finalResult = Math.min(finalResult, result);
        }    

        return memo[idx][d] = finalResult;
    }


    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(d > n) return -1;

        int[][] memo = new int[301][11];
        for(int[] row : memo) Arrays.fill(row, -1);

        return solve(jobDifficulty, n, 0, d, memo);
    }
}