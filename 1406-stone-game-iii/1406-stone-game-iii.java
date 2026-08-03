class Solution {
    int n;
    private int solve(int[] stoneValue, int index, int[] stones){
        if (index >= n) return 0;

        if(stones[index] != -1) return stones[index];

        int result = stoneValue[index] - solve(stoneValue, index + 1, stones);

        if(index + 1 < n){
            result = Math.max(result, stoneValue[index] + stoneValue[index + 1] - solve(stoneValue, index + 2, stones));
        }

        if(index + 2 < n){
            result = Math.max(result, stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2] - solve(stoneValue, index + 3, stones));
        }

        return stones[index] = result;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        int[] stones = new int[n];
        Arrays.fill(stones, -1);

        int diff = solve(stoneValue, 0, stones);

        if(diff > 0) return "Alice";
        else if(diff < 0) return "Bob";
        else return "Tie";
    }
}