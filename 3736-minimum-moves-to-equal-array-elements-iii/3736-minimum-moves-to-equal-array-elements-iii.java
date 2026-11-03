class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            maxi = Math.max(maxi, nums[i]);
        }

        return maxi * n - sum;
    }
}